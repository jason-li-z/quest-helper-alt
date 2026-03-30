package com.questhelper.helpers.mischelpers.bruhsailer;

import com.questhelper.collections.ItemCollections;
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

public class BruhsailerStep73
{
	private final BruhsailerGuide guide;

	// Requirements
	private ItemRequirement coins;
	private ItemRequirement food;
	private ItemRequirement combatGear;
	private ItemRequirement spade;
	private ItemRequirement tinderbox;
	private ItemRequirement axe;

	// Steps
	private DetailedQuestStep travelToShayzien;
	private DetailedQuestStep completeTaleOfTheRighteous;
	private DetailedQuestStep travelToLovakengj;
	private DetailedQuestStep completeForsakenTower;
	private DetailedQuestStep travelToArceuus;
	private DetailedQuestStep completeAscentOfArceuus;
	private DetailedQuestStep wintertodtLoop;
	private DetailedQuestStep travelToPiscarilius;
	private DetailedQuestStep completeQueenOfThieves;
	private DetailedQuestStep completeDepthsOfDespair;
	private DetailedQuestStep completeBearYourSoul;
	private DetailedQuestStep completeGettingAhead;
	private DetailedQuestStep optionalHunterBluegill;
	private DetailedQuestStep completeGardenOfDeath;
	private DetailedQuestStep completeFenkenstrain;

	public BruhsailerStep73(BruhsailerGuide guide)
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
		coins.setTooltip("For various quest costs and travel throughout Kourend");
		food = new ItemRequirement("Food", ItemCollections.GOOD_EATING_FOOD, -1);
		food.setTooltip("For combat encounters during quests. Bring combo food if low level.");
		combatGear = new ItemRequirement("Combat gear", -1, -1);
		combatGear.setTooltip("Weapon and armour for quest combat encounters");
		spade = new ItemRequirement("Spade", ItemID.SPADE);
		tinderbox = new ItemRequirement("Tinderbox", ItemID.TINDERBOX);
		tinderbox.setTooltip("For Wintertodt and various quests");
		axe = new ItemRequirement("Any axe", ItemCollections.AXES);
		axe.setTooltip("For Wintertodt");
	}

	private void setupSteps()
	{
		travelToShayzien = new DetailedQuestStep(guide, new WorldPoint(1518, 3586, 0),
			"Head to the Shayzien area in Kourend. Use the Kourend minecart network if available, " +
			"or run from your current location.");

		completeTaleOfTheRighteous = new DetailedQuestStep(guide, new WorldPoint(1510, 3631, 0),
			"Complete Tale of the Righteous. Select 'Tale of the Righteous' in Quest Helper " +
			"for detailed steps. Start by speaking to Phileas Rimor in Shayzien.",
			food);
		completeTaleOfTheRighteous.conditionToFadeInSidebar(
			new QuestRequirement(QuestHelperQuest.TALE_OF_THE_RIGHTEOUS, QuestState.FINISHED));

		travelToLovakengj = new DetailedQuestStep(guide, new WorldPoint(1564, 3759, 0),
			"Travel north to the Lovakengj area. Use the minecart from Shayzien if unlocked.");

		completeForsakenTower = new DetailedQuestStep(guide, new WorldPoint(1382, 3818, 0),
			"Complete The Forsaken Tower. Select 'The Forsaken Tower' in Quest Helper " +
			"for detailed steps. Start by investigating the tower west of Lovakengj.");
		completeForsakenTower.conditionToFadeInSidebar(
			new QuestRequirement(QuestHelperQuest.THE_FORSAKEN_TOWER, QuestState.FINISHED));

		travelToArceuus = new DetailedQuestStep(guide, new WorldPoint(1720, 3724, 0),
			"Travel east to the Arceuus area.");

		completeAscentOfArceuus = new DetailedQuestStep(guide, new WorldPoint(1698, 3742, 0),
			"Complete The Ascent of Arceuus. Select 'The Ascent of Arceuus' in Quest Helper " +
			"for detailed steps. Start by speaking to Mori in Arceuus.",
			food);
		completeAscentOfArceuus.conditionToFadeInSidebar(
			new QuestRequirement(QuestHelperQuest.THE_ASCENT_OF_ARCEUUS, QuestState.FINISHED));

		wintertodtLoop = new DetailedQuestStep(guide, new WorldPoint(1631, 3962, 0),
			"Travel to the Wintertodt camp. Do Wintertodt runs for Firemaking XP, " +
			"supply crates, and Construction XP. Use the minecart between Lovakengj and " +
			"the Wintertodt camp for efficient looping. Continue until you have the " +
			"Firemaking level you need or have gathered sufficient supplies from crates.",
			axe, tinderbox, food);

		travelToPiscarilius = new DetailedQuestStep(guide, new WorldPoint(1807, 3726, 0),
			"Travel to the Piscarilius area in eastern Kourend. Use the minecart network " +
			"if available.");

		completeQueenOfThieves = new DetailedQuestStep(guide, new WorldPoint(1797, 3782, 0),
			"Complete The Queen of Thieves. Select 'The Queen of Thieves' in Quest Helper " +
			"for detailed steps. Start by speaking to Tomas Lawry in Piscarilius.");
		completeQueenOfThieves.conditionToFadeInSidebar(
			new QuestRequirement(QuestHelperQuest.THE_QUEEN_OF_THIEVES, QuestState.FINISHED));

		completeDepthsOfDespair = new DetailedQuestStep(guide, new WorldPoint(1830, 3690, 0),
			"Complete The Depths of Despair. Select 'The Depths of Despair' in Quest Helper " +
			"for detailed steps. Start by speaking to Lord Kandur Hosidius in Hosidius.",
			food);
		completeDepthsOfDespair.conditionToFadeInSidebar(
			new QuestRequirement(QuestHelperQuest.THE_DEPTHS_OF_DESPAIR, QuestState.FINISHED));

		completeBearYourSoul = new DetailedQuestStep(guide, new WorldPoint(1635, 3809, 0),
			"Complete the Bear Your Soul miniquest. Select 'Bear Your Soul' in Quest Helper " +
			"for detailed steps. Speak to Aretha at the Soul Altar.");
		completeBearYourSoul.conditionToFadeInSidebar(
			new QuestRequirement(QuestHelperQuest.BEAR_YOUR_SOUL, QuestState.FINISHED));

		completeGettingAhead = new DetailedQuestStep(guide, new WorldPoint(1540, 3553, 0),
			"Complete Getting Ahead. Select 'Getting Ahead' in Quest Helper for detailed steps. " +
			"Start by speaking to Gordon in the farm south of Shayzien. " +
			"Warning: You will fight a Headless Beast. Bring food and protect from melee.",
			food);
		completeGettingAhead.conditionToFadeInSidebar(
			new QuestRequirement(QuestHelperQuest.GETTING_AHEAD, QuestState.FINISHED));

		optionalHunterBluegill = new DetailedQuestStep(guide, new WorldPoint(1370, 3632, 0),
			"(Optional) If you need Hunter level 35, catch bluegills at Lake Molch using " +
			"aerial fishing. This requires a cormorant and fish chunks. " +
			"This is optional and can be skipped if your Hunter level is already sufficient.");

		completeGardenOfDeath = new DetailedQuestStep(guide, new WorldPoint(1228, 3724, 0),
			"Complete The Garden of Death. Select 'The Garden of Death' in Quest Helper " +
			"for detailed steps. Travel to the Garden of Death west of Kourend.",
			spade);
		completeGardenOfDeath.conditionToFadeInSidebar(
			new QuestRequirement(QuestHelperQuest.THE_GARDEN_OF_DEATH, QuestState.FINISHED));

		completeFenkenstrain = new DetailedQuestStep(guide, new WorldPoint(3551, 3548, 0),
			"Complete Creature of Fenkenstrain if not already done. Select 'Creature of Fenkenstrain' " +
			"in Quest Helper for detailed steps. You will need to travel to Morytania. " +
			"Warning: Bring antipoison for the Mort Myre Swamp route if passing through.",
			food);
		completeFenkenstrain.conditionToFadeInSidebar(
			new QuestRequirement(QuestHelperQuest.CREATURE_OF_FENKENSTRAIN, QuestState.FINISHED));
	}

	public QuestStep getFirstStep()
	{
		return travelToShayzien;
	}

	public List<ItemRequirement> getItemRequirements()
	{
		return Arrays.asList(coins, food, spade, tinderbox, axe);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 73: Kourend Quests & Activities",
			Arrays.asList(travelToShayzien, completeTaleOfTheRighteous,
				travelToLovakengj, completeForsakenTower,
				travelToArceuus, completeAscentOfArceuus,
				wintertodtLoop, travelToPiscarilius,
				completeQueenOfThieves, completeDepthsOfDespair,
				completeBearYourSoul, completeGettingAhead,
				optionalHunterBluegill, completeGardenOfDeath,
				completeFenkenstrain),
			coins, food, spade, tinderbox, axe);
	}
}
