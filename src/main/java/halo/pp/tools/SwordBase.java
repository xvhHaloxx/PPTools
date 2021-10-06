package halo.pp.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SwordBase extends SwordItem{
    
    protected SwordBase(ToolMaterial material) {
        super(material, 17, -1.5f, new Item.Settings().group(ItemGroup.TOOLS).group(CustomCreativeTabs.PPTAB));
    }
    
}
