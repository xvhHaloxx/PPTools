package halo.pp.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class PickaxeBase extends PickaxeItem {

    protected PickaxeBase(ToolMaterial material) {
        super(material, 6, 0, new Item.Settings().group(ItemGroup.TOOLS).group(CustomCreativeTabs.PPTAB));
    }
    
}
