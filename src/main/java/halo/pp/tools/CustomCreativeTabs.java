package halo.pp.tools;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CustomCreativeTabs {

    public static final ItemGroup PPTAB = FabricItemGroupBuilder.build(new Identifier(PPTools.modid, "pptab"),
            () -> new ItemStack(PPTools.RAW_PP));

}
