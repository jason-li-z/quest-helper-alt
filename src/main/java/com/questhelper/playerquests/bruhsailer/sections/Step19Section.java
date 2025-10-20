package com.questhelper.playerquests.bruhsailer.sections;

import com.questhelper.panel.PanelDetails;
import com.questhelper.playerquests.bruhsailer.BruhsailerGuide;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.runelite.PlayerQuestStateRequirement;
import com.questhelper.steps.ConditionalStep;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.NpcStep;
import com.questhelper.steps.QuestStep;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;

import java.util.Arrays;
import java.util.List;

public class Step19Section
{
	private final BruhsailerGuide quest;

	// Requirements
	private ItemRequirement coins1545, bronzePick, pohTab,
		flour3, redberries3, onions6, woad2, pieDish, bucket,
		clay10, copper4;

	// Steps
	private DetailedQuestStep bankStep, breakHouseTab, mineClayCopper, ensureFoodItems;
	private NpcStep makeDyesAggie, buyChronicleCards;

	public Step19Section(BruhsailerGuide quest)
	{
		this.quest = quest;
		setupRequirements();
		setupSteps();
	}

	private void setupRequirements()
	{
		coins1545 = new ItemRequirement("Coins", ItemID.COINS, 1545);
		bronzePick = new ItemRequirement("Bronze pickaxe", ItemID.BRONZE_PICKAXE).isNotConsumed();
		pohTab = new ItemRequirement("House teleport", ItemID.POH_TABLET_TELEPORTTOHOUSE).highlighted();

		flour3 = new ItemRequirement("Pot of flour", ItemID.POT_FLOUR, 3);
		redberries3 = new ItemRequirement("Redberries", ItemID.REDBERRIES, 3);
		onions6 = new ItemRequirement("Onions", ItemID.ONION, 6);
		woad2 = new ItemRequirement("Woad leaves", ItemID.WOADLEAF, 2);
		pieDish = new ItemRequirement("Pie dish", ItemID.PIEDISH);
		bucket = new ItemRequirement("Bucket", ItemID.BUCKET_EMPTY);

		clay10 = new ItemRequirement("Clay", ItemID.CLAY, 10);
		copper4 = new ItemRequirement("Copper ore", ItemID.COPPER_ORE, 4);
	}

	private void setupSteps()
	{
		bankStep = new DetailedQuestStep(quest, new WorldPoint(3254, 3420, 0),
			"[19.0] Bank: withdraw 1,545 gp, a bronze pickaxe, a house tab, 3 pots of flour, 3 redberries, 6 onions, 2 woad leaves, a pie dish, and a bucket.",
			Arrays.asList(coins1545, bronzePick, pohTab, flour3, redberries3, onions6, woad2, pieDish, bucket), null);
		bankStep.considerBankForItemHighlight = true;

		breakHouseTab = new DetailedQuestStep(quest,
			"[19.1] Break the house teleport tab to Rimmington.", pohTab.highlighted());

		mineClayCopper = new DetailedQuestStep(quest, new WorldPoint(2983, 3237, 0),
			"[19.2] Mine 10 clay and 4 copper at the Rimmington mine.", bronzePick);

		makeDyesAggie = new NpcStep(quest, NpcID.AGGIE, new WorldPoint(3086, 3258, 0),
			"[19.3] Run to Draynor. Use onions/woad leaves on Aggie or talk to her to make 3 yellow dyes and 1 blue dye.", onions6, woad2, coins1545);
		makeDyesAggie.addDialogSteps(
			"Can you make dyes for me, please?",
			"Yellow dye.",
			"Blue dye."
		);

		buyChronicleCards = new NpcStep(quest, NpcID.APRILFOOLSHORSESALESMAN, new WorldPoint(3087, 3251, 0),
			"[19.4] Buy 10 Chronicle cards from Diango in Draynor.", coins1545);

		ensureFoodItems = new DetailedQuestStep(quest,
			"[19.5] Ensure you have a pie dish, a bucket, three pots of flour, and three redberries ready.");
	}

	public void wire(ConditionalStep flow, PlayerQuestStateRequirement state)
	{
		flow.addStep(state.getNewState(195), ensureFoodItems); ensureFoodItems.withId(195);
		flow.addStep(state.getNewState(194), buyChronicleCards); buyChronicleCards.withId(194);
		flow.addStep(state.getNewState(193), makeDyesAggie); makeDyesAggie.withId(193);
		flow.addStep(state.getNewState(192), mineClayCopper); mineClayCopper.withId(192);
		flow.addStep(state.getNewState(191), breakHouseTab); breakHouseTab.withId(191);
		flow.addStep(state.getNewState(190), bankStep); bankStep.withId(190);
	}

	public QuestStep getDefaultStep()
	{
		return bankStep;
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 19 — Prep & Dyes", Arrays.asList(
			bankStep, breakHouseTab, mineClayCopper, makeDyesAggie, buyChronicleCards, ensureFoodItems
		));
	}

	// Expose items if needed later
	public ItemRequirement getPohTab()
	{
		return pohTab;
	}
}
