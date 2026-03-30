package com.questhelper.helpers.mischelpers.bruhsailer;

import com.questhelper.collections.ItemCollections;
import com.questhelper.panel.PanelDetails;
import com.questhelper.questinfo.QuestHelperQuest;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.quest.QuestRequirement;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.NpcStep;
import com.questhelper.steps.ObjectStep;
import com.questhelper.steps.QuestStep;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.QuestState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;
import net.runelite.api.gameval.ObjectID;

public class BruhsailerStep70
{
	private final BruhsailerGuide guide;

	private ItemRequirement coins;
	private ItemRequirement airRunes;
	private ItemRequirement earthStaff;
	private ItemRequirement lawRunes;
	private ItemRequirement fairyStaff;
	private ItemRequirement pinkSkirt;
	private ItemRequirement paste;
	private ItemRequirement wig;
	private ItemRequirement beers;
	private ItemRequirement juteSeeds;
	private ItemRequirement seedDibber;
	private ItemRequirement rake;
	private ItemRequirement ultracompost;
	private ItemRequirement magicSecateurs;
	private ItemRequirement trout;
	private ItemRequirement ropes;
	private ItemRequirement knife;
	private ItemRequirement runeSword;
	private ItemRequirement steelAxe;
	private ItemRequirement bronzeKey;
	private ItemRequirement magicWhistle;
	private ItemRequirement barkSample;
	private ItemRequirement birdSnare;
	private ItemRequirement grain;

	private DetailedQuestStep teleportToLumbridge;
	private NpcStep collectAntiDragonShields;
	private ObjectStep enterZanaris;
	private DetailedQuestStep finishFairytaleI;
	private NpcStep startFairytaleII;
	private ObjectStep freePrinceAli;
	private NpcStep startPorcineOfInterest;
	private DetailedQuestStep buySlayerShopGear;
	private NpcStep returnToMartin;
	private DetailedQuestStep unlockFairyRings;
	private DetailedQuestStep doFairyRingRoute;
	private NpcStep startLilyPadQuest;
	private DetailedQuestStep continueHolyGrail;
	private NpcStep talkToHazelmere;
	private ObjectStep startGardenOfDeath;
	private NpcStep startOlafsQuest;
	private NpcStep killRockCrabs;
	private ObjectStep catchCeruleanTwitch;

	public BruhsailerStep70(BruhsailerGuide guide)
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
		coins = new ItemRequirement("Coins", ItemID.COINS, 7500);
		airRunes = new ItemRequirement("Air runes", ItemID.AIRRUNE, -1);
		earthStaff = new ItemRequirement("Staff of earth", ItemID.STAFF_OF_EARTH).isNotConsumed();
		lawRunes = new ItemRequirement("Law runes", ItemID.LAWRUNE, -1);
		fairyStaff = new ItemRequirement("Dramen or lunar staff", ItemCollections.FAIRY_STAFF, 1, true).isNotConsumed();
		pinkSkirt = new ItemRequirement("Pink skirt", ItemID.PINK_SKIRT).isNotConsumed();
		paste = new ItemRequirement("Paste", ItemID.SKINPASTE).isNotConsumed();
		wig = new ItemRequirement("Wig", ItemID.PLAINWIG).isNotConsumed();
		beers = new ItemRequirement("Beers", ItemID.BEER, 3);
		juteSeeds = new ItemRequirement("Jute seeds", ItemID.JUTE_SEED, 3);
		seedDibber = new ItemRequirement("Seed dibber", ItemID.DIBBER).isNotConsumed();
		rake = new ItemRequirement("Rake", ItemID.RAKE).isNotConsumed();
		ultracompost = new ItemRequirement("Ultracompost", ItemID.BUCKET_ULTRACOMPOST).isNotConsumed();
		magicSecateurs = new ItemRequirement("Magic secateurs", ItemID.FAIRY_ENCHANTED_SECATEURS).isNotConsumed();
		trout = new ItemRequirement("Trout", ItemID.TROUT, 10);
		ropes = new ItemRequirement("Ropes", ItemID.ROPE, 2);
		knife = new ItemRequirement("Knife", ItemID.KNIFE).isNotConsumed();
		runeSword = new ItemRequirement("Rune sword", ItemID.RUNE_SWORD).isNotConsumed();
		steelAxe = new ItemRequirement("Steel axe", ItemID.STEEL_AXE).isNotConsumed();
		bronzeKey = new ItemRequirement("Bronze key", ItemID.PRINCESKEY).isNotConsumed();
		magicWhistle = new ItemRequirement("Magic whistle", ItemID.MAGIC_WHISTLE).isNotConsumed();
		barkSample = new ItemRequirement("Bark sample", ItemID.GRANDTREE_BARKSAMPLE).isNotConsumed();
		birdSnare = new ItemRequirement("Bird snare", ItemID.HUNTING_OJIBWAY_BIRD_SNARE).isNotConsumed();
		grain = new ItemRequirement("Grain", ItemID.GRAIN, 10);
	}

	private void setupSteps()
	{
		teleportToLumbridge = new DetailedQuestStep(guide, new WorldPoint(3222, 3218, 0),
			"Teleport to Lumbridge. You should be at least 11 Hunter from bird runs before starting this sweep.");
		teleportToLumbridge.addRequirement(coins);
		teleportToLumbridge.addRequirement(airRunes);
		teleportToLumbridge.addRequirement(earthStaff);
		teleportToLumbridge.addRequirement(lawRunes);
		teleportToLumbridge.addRequirement(fairyStaff);
		teleportToLumbridge.addRequirement(pinkSkirt);
		teleportToLumbridge.addRequirement(paste);
		teleportToLumbridge.addRequirement(wig);
		teleportToLumbridge.addRequirement(beers);
		teleportToLumbridge.addRequirement(juteSeeds);
		teleportToLumbridge.addRequirement(seedDibber);
		teleportToLumbridge.addRequirement(rake);
		teleportToLumbridge.addRequirement(ultracompost);
		teleportToLumbridge.addRequirement(magicSecateurs);
		teleportToLumbridge.addRequirement(trout);
		teleportToLumbridge.addRequirement(ropes);
		teleportToLumbridge.addRequirement(knife);
		teleportToLumbridge.addRequirement(runeSword);
		teleportToLumbridge.addRequirement(steelAxe);
		teleportToLumbridge.addRequirement(bronzeKey);
		teleportToLumbridge.addRequirement(magicWhistle);
		teleportToLumbridge.addRequirement(barkSample);
		teleportToLumbridge.addRequirement(birdSnare);
		teleportToLumbridge.addRequirement(grain);

		collectAntiDragonShields = new NpcStep(guide, NpcID.DUKE_OF_LUMBRIDGE, new WorldPoint(3210, 3220, 1),
			"Talk to Duke Horacio and grab a few anti-dragon shields before heading to Zanaris.");

		enterZanaris = new ObjectStep(guide, ObjectID.ZANARISDOOR, new WorldPoint(3202, 3169, 0),
			"Enter Zanaris and finish Fairytale I. Use the low-level shortcut to the cosmic altar for the diary while you're in there.", fairyStaff);

		finishFairytaleI = new DetailedQuestStep(guide, new WorldPoint(2375, 4385, 0),
			"Complete Fairytale I in full here. Use the RuneLite quest helper for the Tanglefoot fight and the safespot if you want the low-level flinch.");
		finishFairytaleI.conditionToFadeInSidebar(new QuestRequirement(QuestHelperQuest.FAIRYTALE_I__GROWING_PAINS, QuestState.FINISHED));

		startFairytaleII = new NpcStep(guide, NpcID.MARTIN_THE_MASTER_FARMER, new WorldPoint(3078, 3256, 0),
			"Leave Zanaris, run to Draynor, and start Fairytale II with Martin the Master Farmer. Bank your extra shields first.");

		freePrinceAli = new ObjectStep(guide, ObjectID.ALIDOOR, new WorldPoint(3123, 3243, 0),
			"Free Prince Ali with your bronze key while you're in the area.", bronzeKey.highlighted(), pinkSkirt, paste, wig);
		freePrinceAli.addIcon(ItemID.PRINCESKEY);

		startPorcineOfInterest = new NpcStep(guide, NpcID.PORCINE_SPRIA, new WorldPoint(3092, 3267, 0),
			"Do A Porcine of Interest in full for the easy route unlocks and Slayer setup.");

		buySlayerShopGear = new DetailedQuestStep(guide, new WorldPoint(3092, 3267, 0),
			"Buy your Slayer supplies: mirror shield, rock hammer, 2 facemasks, earmuffs, nose peg, spiny helmet, " +
				"unlit bug lantern, insulated boots, boots of stone, bag of salt, slayer gloves, 30 ice coolers, as " +
				"many enchanted gems as you can carry, and grab 10 grain.");
		buySlayerShopGear.addRequirement(coins);
		buySlayerShopGear.addRequirement(grain);

		returnToMartin = new NpcStep(guide, NpcID.MARTIN_THE_MASTER_FARMER, new WorldPoint(3078, 3256, 0),
			"Rebank after the Draynor errands, then return to Martin to continue Fairytale II toward fairy ring access.");

		unlockFairyRings = new DetailedQuestStep(guide, new WorldPoint(2355, 4455, 0),
			"Continue Fairytale II until fairy rings are usable. RuneLite's Fairytale II helper covers the certificate, " +
				"pickpocket, and queen hideout steps.");
		unlockFairyRings.conditionToFadeInSidebar(new QuestRequirement(QuestHelperQuest.FAIRYTALE_II__CURE_A_QUEEN, QuestState.IN_PROGRESS));

		doFairyRingRoute = new DetailedQuestStep(guide, new WorldPoint(2409, 4369, 0),
			"Run the fairy ring route: CIR for the diary, ALS for McGrubor's Wood and plant your 3 jute seeds, BIS for " +
				"Ardougne Zoo, AIR for the diary, optional Auburnvale addy axe, DIS for the diary, AJP for Varlamore " +
				"and The Ribbiting Tale in full, BJR for Holy Grail, CLS for Hazelmere, BLS for The Garden of Death " +
				"until Lake Molch access, then DKS for Olaf's Quest and the Fremennik diary steps.");
		doFairyRingRoute.addRequirement(juteSeeds);
		doFairyRingRoute.addRequirement(seedDibber);
		doFairyRingRoute.addRequirement(rake);
		doFairyRingRoute.addRequirement(ultracompost);
		doFairyRingRoute.addRequirement(magicSecateurs);
		doFairyRingRoute.addRequirement(ropes);
		doFairyRingRoute.addRequirement(knife);
		doFairyRingRoute.addRequirement(runeSword);
		doFairyRingRoute.addRequirement(steelAxe);
		doFairyRingRoute.addRequirement(magicWhistle);
		doFairyRingRoute.addRequirement(barkSample);
		doFairyRingRoute.addRequirement(birdSnare);

		startLilyPadQuest = new NpcStep(guide, NpcID.FROG_QUEST_MARCELLUS_NORMAL, new WorldPoint(1683, 2973, 0),
			"At fairy ring AJP, complete The Ribbiting Tale of a Lily Pad Labour Dispute and grab a sweetcorn for Recipe for Disaster.");

		continueHolyGrail = new DetailedQuestStep(guide, new WorldPoint(2501, 4715, 0),
			"At BJR, continue Holy Grail far enough to grab the Holy Grail, but do not blow the magic whistle yet.");

		talkToHazelmere = new NpcStep(guide, NpcID.GRANDTREE_HAZELMERE, new WorldPoint(2677, 3087, 1),
			"Use CLS and talk to Hazelmere for The Grand Tree while carrying the bark sample.", barkSample);

		startGardenOfDeath = new ObjectStep(guide, ObjectID.TGOD_TENT, new WorldPoint(1314, 3470, 0),
			"Use BLS and start The Garden of Death. Explore the cave until you have enough words to be sent to Lake Molch.");

		startOlafsQuest = new NpcStep(guide, NpcID.OLAF, new WorldPoint(2722, 3727, 0),
			"Use DKS and start Olaf's Quest, then do the nearby Fremennik diary steps before moving on.");

		killRockCrabs = new NpcStep(guide, NpcID.HORROR_ROCKCRAB, new WorldPoint(2707, 3723, 0),
			"Kill 5 rock crabs for the diary.", true);
		killRockCrabs.addAlternateNpcs(NpcID.HORROR_ROCKCRAB_SMALL);

		catchCeruleanTwitch = new ObjectStep(guide, ObjectID.HUNTING_OJIBWAY_TRAP_FULL_POLAR, new WorldPoint(2724, 3773, 0),
			"Catch a Cerulean twitch for the diary.", birdSnare.highlighted());

		teleportToLumbridge.withId(7001);
		collectAntiDragonShields.withId(7002);
		enterZanaris.withId(7003);
		finishFairytaleI.withId(7004);
		startFairytaleII.withId(7005);
		freePrinceAli.withId(7006);
		startPorcineOfInterest.withId(7007);
		buySlayerShopGear.withId(7008);
		returnToMartin.withId(7009);
		unlockFairyRings.withId(7010);
		doFairyRingRoute.withId(7011);
		startLilyPadQuest.withId(7012);
		continueHolyGrail.withId(7013);
		talkToHazelmere.withId(7014);
		startGardenOfDeath.withId(7015);
		startOlafsQuest.withId(7016);
		killRockCrabs.withId(7017);
		catchCeruleanTwitch.withId(7018);
	}

	public QuestStep getFirstStep()
	{
		return teleportToLumbridge;
	}

	public List<ItemRequirement> getItemRequirements()
	{
		return Arrays.asList(coins, airRunes, earthStaff, lawRunes, fairyStaff, pinkSkirt, paste, wig, beers,
			juteSeeds, seedDibber, rake, ultracompost, magicSecateurs, trout, ropes, knife, runeSword,
			steelAxe, bronzeKey, magicWhistle, barkSample, birdSnare, grain);
	}

	public List<QuestStep> getSteps()
	{
		return Arrays.asList(teleportToLumbridge, collectAntiDragonShields, enterZanaris, finishFairytaleI,
			startFairytaleII, freePrinceAli, startPorcineOfInterest, buySlayerShopGear, returnToMartin,
			unlockFairyRings, doFairyRingRoute, startLilyPadQuest, continueHolyGrail, talkToHazelmere,
			startGardenOfDeath, startOlafsQuest, killRockCrabs, catchCeruleanTwitch);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 70: Fairy Rings, Varlamore & Fremennik Sweep",
			getSteps(),
			coins, airRunes, earthStaff, lawRunes, fairyStaff, pinkSkirt, paste, wig, beers, juteSeeds,
			seedDibber, rake, ultracompost, magicSecateurs, trout, ropes, knife, runeSword, steelAxe,
			bronzeKey, magicWhistle, barkSample, birdSnare, grain).withPanelId(70);
	}
}
