package vazkii.botania.fabric.integration.emi;

import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;

import vazkii.botania.api.recipe.ITerraPlateRecipe;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.block.tile.mana.TilePool;

import java.util.List;

public class TerrestrialAgglomerationEmiRecipe extends BotaniaEmiRecipe {
	private static final EmiStack PLATE = EmiStack.of(ModBlocks.terraPlate);
	private final int mana;

	public TerrestrialAgglomerationEmiRecipe(ITerraPlateRecipe recipe) {
		super(BotaniaEmiPlugin.TERRESTRIAL_AGGLOMERATION, recipe);
		this.input = recipe.getIngredients().stream().map(EmiIngredient::of).toList();
		this.output = List.of(EmiStack.of(recipe.getResultItem()));
		this.mana = recipe.getMana();
	}

	@Override
	public int getDisplayHeight() {
		return 107;
	}

	@Override
	public int getDisplayWidth() {
		return 106;
	}

	@Override
	public void addWidgets(WidgetHolder widgets) {
		widgets.add(new ManaWidget(2, 100, mana, TilePool.MAX_MANA / 10));
		RunicAltarEmiRecipe.addRunicAltarWidgets(widgets, this, input, PLATE, output.get(0));
	}
}
