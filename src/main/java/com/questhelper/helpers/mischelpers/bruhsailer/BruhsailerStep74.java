package com.questhelper.helpers.mischelpers.bruhsailer;

import com.questhelper.panel.PanelDetails;
import com.questhelper.questinfo.QuestHelperQuest;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.quest.QuestRequirement;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.QuestStep;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.QuestState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;

public class BruhsailerStep74
{
	private final BruhsailerGuide guide;

	// Requirements
	private ItemRequirement coins;
	private ItemRequirement ores;
	private ItemRequirement airRunes;
	private ItemRequirement lawRunes;
	private ItemRequirement excalibur;
	private ItemRequirement holyTableNapkin;
	private ItemRequirement magicWhistle;
	private ItemRequirement food;

	// Steps
	private DetailedQuestStep bankForBlastFurnace;
	private DetailedQuestStep teleportToBlastFurnace;
	private DetailedQuestStep doBlastFurnace;
	private DetailedQuestStep travelToKeldagrim;
	private DetailedQuestStep harvestHops;
	private DetailedQuestStep startFermentation;
	private DetailedQuestStep teleportToCamelot;
	private DetailedQuestStep completeHolyGrail;

	public BruhsailerStep74(BruhsailerGuide guide)
	{
		this.guide = guide;
	}

	public void setup()
	{
		setupRequirements();
		setupSteps();
	}

	private void setupRequirements()
	{
		coins = new ItemRequirement("Coins", ItemID.COINS, 5000);
		coins.setTooltip("For Blast Furnace and other costs");
		ores = new ItemRequirement("Ores for Blast Furnace", ItemID.IRON_ORE, -1);
		ores.setTooltip("Bring whatever ores you want to smelt at the Blast Furnace");
		airRunes = new ItemRequirement("Air runes", ItemID.AIRRUNE, -1);
		airRunes.setTooltip("For Camelot teleport");
		lawRunes = new ItemRequirement("Law runes", ItemID.LAWRUNE, -1);
		lawRunes.setTooltip("For Camelot teleport");
		excalibur = new ItemRequirement("Excalibur", ItemID.EXCALIBUR);
		excalibur.setTooltip("Obtained during Merlin's Crystal");
		holyTableNapkin = new ItemRequirement("Holy table napkin", ItemID.HOLY_TABLE_NAPKIN);
		holyTableNapkin.setTooltip("Needed for Holy Grail quest");
		magicWhistle = new ItemRequirement("Magic whistles", ItemID.MAGIC_WHISTLE, 2);
		magicWhistle.setTooltip("Needed for Holy Grail quest - bring 2");
		food = new ItemRequirement("Food", ItemID.TROUT, -1);
		food.setTooltip("For Holy Grail combat encounters");
	}

	private void setupSteps()
	{
		bankForBlastFurnace = new DetailedQuestStep(guide,
			"Bank and grab your ores, coins, and stamina potions for the Blast Furnace. " +
			"Also prepare your Camelot teleport runes, Excalibur, holy table napkin, and " +
			"magic whistles for Holy Grail afterwards.",
			coins, ores, airRunes, lawRunes, excalibur, holyTableNapkin, magicWhistle);

		teleportToBlastFurnace = new DetailedQuestStep(guide, new WorldPoint(1942, 4958, 0),
			"Use the minigame teleport to travel to the Blast Furnace. " +
			"Open the minigame teleport menu and select 'Blast Furnace'.");

		doBlastFurnace = new DetailedQuestStep(guide, new WorldPoint(1942, 4958, 0),
			"Smith bars at the Blast Furnace. Use the conveyor belt to add your ores " +
			"and collect the bars from the bar dispenser. Remember to pay the Blast Furnace " +
			"foreman if you are under 60 Smithing (2500gp per 10 minutes).", coins, ores);

		travelToKeldagrim = new DetailedQuestStep(guide, new WorldPoint(2838, 10130, 0),
			"Travel to Keldagrim. You can use the trapdoor at the Grand Exchange " +
			"(WorldPoint 3140, 3504) or take the mine cart from the Blast Furnace area.");

		harvestHops = new DetailedQuestStep(guide, new WorldPoint(2854, 10203, 0),
			"Check on and harvest any hops growing in the Keldagrim hops patch. " +
			"If your barley from step 72 is ready, harvest it here or at a hops patch " +
			"that is convenient.");

		startFermentation = new DetailedQuestStep(guide, new WorldPoint(2854, 10203, 0),
			"Start brewing at the Keldagrim brewery if you have the ingredients. " +
			"Add barley malt and other ingredients to the fermenting vat to begin a brew.");

		teleportToCamelot = new DetailedQuestStep(guide, new WorldPoint(2757, 3477, 0),
			"Teleport to Camelot using your air and law runes (or a Camelot teleport tab).",
			airRunes, lawRunes);

		completeHolyGrail = new DetailedQuestStep(guide, new WorldPoint(2757, 3477, 0),
			"Complete the Holy Grail quest. Select 'Holy Grail' in Quest Helper for " +
			"detailed steps. You will need your Excalibur, holy table napkin, and magic whistles. " +
			"Speak to King Arthur in Camelot Castle to start. You will need to fight the " +
			"Black Knight Titan (level 120) - protect from melee and bring food.",
			excalibur, holyTableNapkin, magicWhistle, food);
		completeHolyGrail.conditionToFadeInSidebar(
			new QuestRequirement(QuestHelperQuest.HOLY_GRAIL, QuestState.FINISHED));

		bankForBlastFurnace.withId(7401);
		teleportToBlastFurnace.withId(7402);
		doBlastFurnace.withId(7403);
		travelToKeldagrim.withId(7404);
		harvestHops.withId(7405);
		startFermentation.withId(7406);
		teleportToCamelot.withId(7407);
		completeHolyGrail.withId(7408);
	}

	public QuestStep getFirstStep()
	{
		return bankForBlastFurnace;
	}

	public List<ItemRequirement> getItemRequirements()
	{
		return Arrays.asList(coins, ores, airRunes, lawRunes, excalibur, holyTableNapkin,
			magicWhistle, food);
	}

	public List<QuestStep> getSteps()
	{
		return Arrays.asList(bankForBlastFurnace, teleportToBlastFurnace, doBlastFurnace,
			travelToKeldagrim, harvestHops, startFermentation,
			teleportToCamelot, completeHolyGrail);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 74: Blast Furnace, Keldagrim & Holy Grail",
			getSteps(),
			coins, ores, airRunes, lawRunes, excalibur, holyTableNapkin,
			magicWhistle, food).withPanelId(74);
	}
}
