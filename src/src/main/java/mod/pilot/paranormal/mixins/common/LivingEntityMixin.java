package mod.pilot.paranormal.mixins.common;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin{
    @Inject(method = "kill", at = @At("RETURN"))
    private void onConstructor(CallbackInfo info){
        System.out.println("Mixin injected code for killing entity " + this);
    }
}
