package halo.pp.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class ShovelBase extends ShovelItem{
    
    protected ShovelBase(ToolMaterial material) {
        super(material, 8, 0, new Item.Settings().group(ItemGroup.TOOLS).group(CustomCreativeTabs.PPTAB));
    }
    
}
