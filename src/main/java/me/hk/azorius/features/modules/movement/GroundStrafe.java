package me.hk.azorius.features.modules.movement;

import me.hk.azorius.Azorius;
import me.hk.azorius.event.events.MoveEvent;
import me.hk.azorius.features.modules.Module;
import me.hk.azorius.features.setting.Setting;
import me.hk.azorius.util.EntityUtil;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
public class GroundStrafe extends Module {

    public  final Setting<Boolean> useTimer = register(new Setting<>("UseTimer", true));
    public  final Setting<Boolean> onGroundOnly = register(new Setting<>("OnGroundOnly", false));
    public  final Setting<Boolean> noLiquid = register(new Setting<>("NoLiquid", true));
    public  GroundStrafe INSTANCE;
    double playerSpeed;

    public GroundStrafe() {
        super("GroundStrafe", "Speed Mode To Help You Go Down Stairs Faster", Category.Movement,false,false);
        INSTANCE = this;
    }

    @SubscribeEvent
    public void onMove(MoveEvent event) {
        if ((!noLiquid.getValue() && !mc.player.isInLava() || !mc.player.isInWater())) {
            if (mc.player.collidedHorizontally || mc.player.movementInput.sneak || mc.player.moveForward == 0) return;
            if (mc.player.onGround || !onGroundOnly.getValue()) {
                if (mc.player.ticksExisted % 2 == 0) {
                    Azorius.tickManager.setTicks(1.0f);
                } else {
                    if (useTimer.getValue()) {
                        Azorius.tickManager.setTicks(1.2f);
                    } else {
                        Azorius.tickManager.setTicks(1.0f);
                    }
                }
                playerSpeed = EntityUtil.getBaseMoveSpeed();
            }
        } else {
            Azorius.tickManager.setTicks(1.0f);
        }

        playerSpeed = Math.max(playerSpeed, EntityUtil.getBaseMoveSpeed());
        EntityUtil.setVanilaSpeed(event, playerSpeed);

        if (!useTimer.getValue()) {
            Azorius.tickManager.setTicks(1.0f);
        }
    }


    @Override
    public void onDisable() {
        Azorius.tickManager.setTicks(1.0f);
    }
}
