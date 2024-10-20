package mod.pilot.paranormal.events;

import mod.pilot.paranormal.Paranormal;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Paranormal.MOD_ID)
public class ParanormalEventSubscriber {
    @SubscribeEvent
    public static void onEntitySpawn(EntityJoinLevelEvent event){}
}
