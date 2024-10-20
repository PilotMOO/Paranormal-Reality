package mod.pilot.paranormal.mixins.client;

import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin{
    @Inject(method = "<init>*", at = @At("RETURN"))
    private void onConstructor(CallbackInfo info){
        System.out.println("Creating a new LocalPlayer");
    }
}
