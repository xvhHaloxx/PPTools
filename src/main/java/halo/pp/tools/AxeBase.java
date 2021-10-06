package halo.pp.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class AxeBase extends AxeItem{

    protected AxeBase(ToolMaterial material) {
        super(material, 19, -2, new Item.Settings().group(ItemGroup.TOOLS).group(CustomCreativeTabs.PPTAB));
    }
    
}