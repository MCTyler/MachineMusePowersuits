package net.machinemuse.powersuits.item

import cpw.mods.fml.common.Optional
import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.machinemuse.api.ModuleManager
import net.machinemuse.powersuits.powermodule.misc.ThaumGogglesModule
import net.machinemuse.utils.render.MuseRenderer
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack
import thaumcraft.api.IGoggles
import thaumcraft.api.nodes.IRevealer

@Optional.Interface(iface = "thaumcraft.api.IGoggles", modid = "Thaumcraft", striprefs = true)
object ItemPowerArmorHelmet extends ItemPowerArmor(0, 0)
//with IBreathableArmor
with IGoggles
with IRevealer
{
  val iconpath = MuseRenderer.ICON_PREFIX + "armorhead"

  setUnlocalizedName("powerArmorHelmet")

  //
  //  // IBreathableArmor
  //  def handleGearType(gearType: EnumGearType): Boolean = gearType eq EnumGearType.HELMET
  //
  //  def canBreathe(helm: ItemStack, player: EntityPlayer, gearType: EnumGearType): Boolean =
  //    ModuleManager.itemHasActiveModule(helm, AirtightSealModule.AIRTIGHT_SEAL_MODULE)


  @SideOnly(Side.CLIENT)
  override def registerIcons(iconRegister: IIconRegister) {
    itemIcon = iconRegister.registerIcon(iconpath)
  }

  override def showIngamePopups(itemstack: ItemStack, player: EntityLivingBase): Boolean =
    ModuleManager.itemHasActiveModule(itemstack, ThaumGogglesModule.MODULE_THAUM_GOGGLES)

  override def showNodes(itemstack: ItemStack, player: EntityLivingBase): Boolean =
    ModuleManager.itemHasActiveModule(itemstack, ThaumGogglesModule.MODULE_THAUM_GOGGLES)
}