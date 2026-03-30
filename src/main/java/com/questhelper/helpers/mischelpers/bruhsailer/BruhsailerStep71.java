package com.questhelper.helpers.mischelpers.bruhsailer;

import com.questhelper.collections.ItemCollections;
import com.questhelper.panel.PanelDetails;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.NpcStep;
import com.questhelper.steps.ObjectStep;
import com.questhelper.steps.QuestStep;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;
import net.runelite.api.gameval.ObjectID;

public class BruhsailerStep71
{
	private final BruhsailerGuide guide;

	private ItemRequirement keldaSeeds;
	private ItemRequirement rake;
	private ItemRequirement seedDibber;
	private ItemRequirement spade;
	private ItemRequirement forgettableItem;
	private ItemRequirement whitePearlSeed;
	private ItemRequirement cakeTin;
	private ItemRequirement ironBar;
	private ItemRequirement swampTar;
	private ItemRequirement bucketOfWax;
	private ItemRequirement rope;
	private ItemRequirement mapleLogs;
	private ItemRequirement plank;
	private ItemRequirement climbingBoots;
	private ItemRequirement gamesNecklace;
	private ItemRequirement steelAxe;
	private ItemRequirement leather;
	private ItemRequirement needle;
	private ItemRequirement thread;
	private ItemRequirement airRunes;
	private ItemRequirement fireStaff;
	private ItemRequirement lawRunes;
	private ItemRequirement chronicle;
	private ItemRequirement coins;
	private ItemRequirement earthRunes;
	private ItemRequirement mindRunes;

	private DetailedQuestStep collectMissingForgettableItem;
	private NpcStep talkToRowdyDwarf;
	private NpcStep talkToGauss;
	private ObjectStep plantKeldaHops;
	private DetailedQuestStep bankForTrollRoute;
	private ObjectStep enterMountainCamp;
	private NpcStep talkToHamal;
	private NpcStep talkToBurntmeat;
	private NpcStep talkToEadgar;
	private NpcStep talkToParrotyPete;
	private NpcStep startTrollRomance;
	private NpcStep talkToTenzing;
	private NpcStep talkToDunstan;
	private DetailedQuestStep stopAtWaxedSled;

	public BruhsailerStep71(BruhsailerGuide guide)
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
		keldaSeeds = new ItemRequirement("Kelda seeds", ItemID.KELDA_HOP_SEED, 4);
		rake = new ItemRequirement("Rake", ItemID.RAKE).isNotConsumed();
		seedDibber = new ItemRequirement("Seed dibber", ItemID.DIBBER).isNotConsumed();
		spade = new ItemRequirement("Spade", ItemID.SPADE).isNotConsumed();
		forgettableItem = new ItemRequirement("The Forgettable Tale item if still undelivered", -1, -1).isNotConsumed();
		whitePearlSeed = new ItemRequirement("White pearl seed", ItemID.MDAUGHTER_WHITE_PEARL_SEED).isNotConsumed();
		cakeTin = new ItemRequirement("Cake tin", ItemID.CAKE_TIN).isNotConsumed();
		ironBar = new ItemRequirement("Iron bar", ItemID.IRON_BAR).isNotConsumed();
		swampTar = new ItemRequirement("Swamp tar", ItemID.SWAMP_TAR).isNotConsumed();
		bucketOfWax = new ItemRequirement("Bucket of wax", ItemID.BUCKET_WAX).isNotConsumed();
		rope = new ItemRequirement("Rope", ItemID.ROPE).isNotConsumed();
		mapleLogs = new ItemRequirement("Maple logs", ItemID.MAPLE_LOGS).isNotConsumed();
		plank = new ItemRequirement("Plank", ItemID.WOODPLANK).isNotConsumed();
		climbingBoots = new ItemRequirement("Climbing boots", ItemCollections.CLIMBING_BOOTS).isNotConsumed();
		gamesNecklace = new ItemRequirement("Games necklace", ItemCollections.GAMES_NECKLACES).isNotConsumed();
		steelAxe = new ItemRequirement("Steel axe", ItemID.STEEL_AXE).isNotConsumed();
		leather = new ItemRequirement("Leather", ItemID.HARD_LEATHER).isNotConsumed();
		needle = new ItemRequirement("Needle", ItemID.NEEDLE).isNotConsumed();
		thread = new ItemRequirement("Thread", ItemID.THREAD).isNotConsumed();
		airRunes = new ItemRequirement("Air runes", ItemID.AIRRUNE, -1);
		fireStaff = new ItemRequirement("Staff of fire", ItemCollections.FIRE_STAFF).isNotConsumed();
		lawRunes = new ItemRequirement("Law runes", ItemID.LAWRUNE, -1);
		chronicle = new ItemRequirement("Chronicle", ItemID.CHRONICLE).isNotConsumed();
		coins = new ItemRequirement("Coins", ItemID.COINS, 6693);
		earthRunes = new ItemRequirement("Earth runes", ItemID.EARTHRUNE, -1);
		mindRunes = new ItemRequirement("Mind runes", ItemID.MINDRUNE, -1);
	}

	private void setupSteps()
	{
		collectMissingForgettableItem = new DetailedQuestStep(guide, new WorldPoint(2827, 10214, 0),
			"If you still haven't turned in the required item for Forgettable Tale, do that first, then continue the " +
				"quest until you are collecting the last Kelda seeds.");
		collectMissingForgettableItem.addRequirement(keldaSeeds);
		collectMissingForgettableItem.addRequirement(rake);
		collectMissingForgettableItem.addRequirement(seedDibber);
		collectMissingForgettableItem.addRequirement(spade);
		collectMissingForgettableItem.addRequirement(forgettableItem);
		collectMissingForgettableItem.addRequirement(whitePearlSeed);
		collectMissingForgettableItem.addRequirement(cakeTin);
		collectMissingForgettableItem.addRequirement(ironBar);
		collectMissingForgettableItem.addRequirement(swampTar);
		collectMissingForgettableItem.addRequirement(bucketOfWax);
		collectMissingForgettableItem.addRequirement(rope);
		collectMissingForgettableItem.addRequirement(mapleLogs);
		collectMissingForgettableItem.addRequirement(plank);
		collectMissingForgettableItem.addRequirement(climbingBoots);
		collectMissingForgettableItem.addRequirement(gamesNecklace);
		collectMissingForgettableItem.addRequirement(steelAxe);
		collectMissingForgettableItem.addRequirement(leather);
		collectMissingForgettableItem.addRequirement(needle);
		collectMissingForgettableItem.addRequirement(thread);
		collectMissingForgettableItem.addRequirement(airRunes);
		collectMissingForgettableItem.addRequirement(fireStaff);
		collectMissingForgettableItem.addRequirement(lawRunes);
		collectMissingForgettableItem.addRequirement(chronicle);
		collectMissingForgettableItem.addRequirement(coins);
		collectMissingForgettableItem.addRequirement(earthRunes);
		collectMissingForgettableItem.addRequirement(mindRunes);

		talkToRowdyDwarf = new NpcStep(guide, NpcID.DWARF_CITY_ROWDY_DWARF, new WorldPoint(2914, 10198, 0),
			"Get the third Kelda seed from the Rowdy Dwarf in the Laughing Miner and also pick up a beer for an empty glass.");

		talkToGauss = new NpcStep(guide, NpcID.DWARF_CITY_DWARF_MAN6, new WorldPoint(2839, 10196, 0),
			"Talk to Gauss for the fourth Kelda seed, then continue Forgettable Tale until the hops are planted.");

		plantKeldaHops = new ObjectStep(guide, ObjectID.FARMING_HOPS_PATCH_KELDAGRIM, new WorldPoint(2854, 10203, 0),
			"Plant your Kelda hops and finish this leg of Forgettable Tale.", keldaSeeds.highlighted(), rake, seedDibber, spade);
		plantKeldaHops.addIcon(ItemID.KELDA_HOP_SEED);

		bankForTrollRoute = new DetailedQuestStep(guide, new WorldPoint(2839, 10201, 0),
			"Bank in Keldagrim and withdraw the troll route setup for Mountain Daughter, Eadgar's Ruse, and Troll Romance.");

		enterMountainCamp = new ObjectStep(guide, ObjectID.MDAUGHTER_CLIFF_BOULDER, new WorldPoint(2766, 3667, 0),
			"Return to fairy ring AJR and enter the Mountain Camp to start Mountain Daughter.", whitePearlSeed, plank);

		talkToHamal = new NpcStep(guide, NpcID.MDAUGHTER_HAMAL, new WorldPoint(2810, 3672, 0),
			"Complete Mountain Daughter in full, then use the secret Troll Stronghold entrance for the next quest leg.");

		talkToBurntmeat = new NpcStep(guide, NpcID.EADGAR_TROLL_CHIEF_COOK, new WorldPoint(2845, 10057, 1),
			"Speak with Burntmeat in Troll Stronghold's kitchen to skip the long walk and continue Eadgar's Ruse.");

		talkToEadgar = new NpcStep(guide, NpcID.TROLL_EADGAR, new WorldPoint(2891, 10086, 2),
			"Continue Eadgar's Ruse up to the point where you need to collect the parrot.", climbingBoots, airRunes, fireStaff, lawRunes, chronicle, coins, earthRunes, mindRunes);

		talkToParrotyPete = new NpcStep(guide, NpcID.EADGAR_ZOO_KEEPER_AVIARY, new WorldPoint(2612, 3285, 0),
			"Follow the Eadgar's Ruse helper far enough to understand the parrot pickup step, then stop before doing it.");

		startTrollRomance = new NpcStep(guide, NpcID.TROLLROMANCE_UG, new WorldPoint(2827, 10064, 1),
			"Start Troll Romance and continue until you need to collect the flower, after you have the sled.");

		talkToTenzing = new NpcStep(guide, NpcID.DEATH_SHERPA, new WorldPoint(2820, 3555, 0),
			"Talk to Tenzing for the Troll Romance sled steps.", climbingBoots, rope, mapleLogs);

		talkToDunstan = new NpcStep(guide, NpcID.DEATH_SMITHY, new WorldPoint(2919, 3574, 0),
			"Talk to Dunstan to keep Troll Romance moving toward the waxed sled.", ironBar, mapleLogs, rope);

		stopAtWaxedSled = new DetailedQuestStep(guide, new WorldPoint(2919, 3574, 0),
			"Stop this route once the waxed sled is ready and the next Troll Romance step is collecting the flower.");

		collectMissingForgettableItem.withId(7101);
		talkToRowdyDwarf.withId(7102);
		talkToGauss.withId(7103);
		plantKeldaHops.withId(7104);
		bankForTrollRoute.withId(7105);
		enterMountainCamp.withId(7106);
		talkToHamal.withId(7107);
		talkToBurntmeat.withId(7108);
		talkToEadgar.withId(7109);
		talkToParrotyPete.withId(7110);
		startTrollRomance.withId(7111);
		talkToTenzing.withId(7112);
		talkToDunstan.withId(7113);
		stopAtWaxedSled.withId(7114);
	}

	public QuestStep getFirstStep()
	{
		return collectMissingForgettableItem;
	}

	public List<ItemRequirement> getItemRequirements()
	{
		return Arrays.asList(keldaSeeds, rake, seedDibber, spade, forgettableItem, whitePearlSeed, cakeTin,
			ironBar, swampTar, bucketOfWax, rope, mapleLogs, plank, climbingBoots, gamesNecklace, steelAxe,
			leather, needle, thread, airRunes, fireStaff, lawRunes, chronicle, coins, earthRunes, mindRunes);
	}

	public List<QuestStep> getSteps()
	{
		return Arrays.asList(collectMissingForgettableItem, talkToRowdyDwarf, talkToGauss, plantKeldaHops,
			bankForTrollRoute, enterMountainCamp, talkToHamal, talkToBurntmeat, talkToEadgar,
			talkToParrotyPete, startTrollRomance, talkToTenzing, talkToDunstan, stopAtWaxedSled);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 71: Forgettable Tale, Mountain Daughter & Troll Route",
			getSteps(),
			keldaSeeds, rake, seedDibber, spade, forgettableItem, whitePearlSeed, cakeTin, ironBar,
			swampTar, bucketOfWax, rope, mapleLogs, plank, climbingBoots, gamesNecklace, steelAxe,
			leather, needle, thread, airRunes, fireStaff, lawRunes, chronicle, coins, earthRunes,
			mindRunes).withPanelId(71);
	}
}
