package mod.pilot.paranormal.systems;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

import java.util.HashMap;
import java.util.UUID;

public class GravitySwitchSystemManager {
    private static ServerLevel server;
    public static void setServer(ServerLevel server){
        GravitySwitchSystemManager.server = server;
    }
    private static final HashMap<UUID, Axis> EntityGravityHashmap = new HashMap<>();
    public static Entity getEntityFromUUID(UUID id){
        return server.getEntity(id);
    }
    public static Axis getAxisForEntity(Entity entity){
        UUID entityUUID = entity.getUUID();
        return EntityGravityHashmap.getOrDefault(entityUUID, Axis.YPos);
    }
    public static void ChangeEntityAxis(Entity target, Axis newAxis){
        UUID uuid = target.getUUID();
        if (EntityGravityHashmap.containsKey(uuid)){
            EntityGravityHashmap.replace(uuid, newAxis);
            return;
        }
        EntityGravityHashmap.put(uuid, newAxis);
    }

    public enum Axis{
        XPos,
        XNeg,
        YPos,
        YNeg,
        ZPos,
        ZNeg
    }
    public static boolean isNegative(Axis state){
        return state == Axis.XNeg || state == Axis.YNeg || state == Axis.ZNeg;
    }
    public static boolean isNegative(int ordinal){
        return (isNegative(getAxis(ordinal)));
    }
    public static Axis getAxis(int ordinal){
        if (ordinal > Axis.values().length) throw new RuntimeException("Ordinal number " + ordinal + " is larger than the Axis enum!");
        return Axis.values()[ordinal];
    }
}
