/*
 * Player-made guide — Section 1.2 (Step 19)
 */
package com.questhelper.playerquests.bruhsailer;

import com.questhelper.panel.PanelDetails;
import com.questhelper.questhelpers.PlayerMadeQuestHelper;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.NpcStep;
import com.questhelper.steps.QuestStep;
import com.questhelper.playerquests.bruhsailer.sections.Step19Section;
import com.questhelper.playerquests.bruhsailer.sections.Step20Section;
import com.questhelper.playerquests.bruhsailer.sections.Step32Section;
import com.questhelper.playerquests.bruhsailer.sections.Step35Section;
import com.questhelper.playerquests.bruhsailer.sections.Step36Section;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BruhsailerGuide extends PlayerMadeQuestHelper
{
	private Step19Section step19;
	private Step20Section step20;
	private com.questhelper.playerquests.bruhsailer.sections.Step21Section step21;
	private com.questhelper.playerquests.bruhsailer.sections.Step22Section step22;
	private com.questhelper.playerquests.bruhsailer.sections.Step23Section step23;
	private com.questhelper.playerquests.bruhsailer.sections.Step24Section step24;
	private Step32Section step32;
	private Step35Section step35;
	private Step36Section step36;
	// Step 19 items
	private ItemRequirement coins1545, bronzePick, pohTab,
		flour3, redberries3, onions6, woad2, pieDish, bucket,
		clay10, copper4;

	// Steps
	private DetailedQuestStep bankStep, breakHouseTab, mineClayCopper, buyChronicleCards, ensureFoodItems;
	private NpcStep makeDyesAggie;

	// Step 20 items
	private ItemRequirement coins95672;

	// Step 20 steps
	private DetailedQuestStep makePastryAndPies, buyFeathersGerrant, buyRunesBetty, veosToZeah,
		veosCompleteCoK, veosToLandsEnd, grabHunterSupplies, captainMagoroToPiscarilius, fletchWhileWalking;
	private NpcStep talkThurgo;

	// Step 21 items
	private ItemRequirement coins8812, stew, airRunes, mindRunes, hammer, spade;

	// Step 21 steps
	private DetailedQuestStep piscariliusPrep, enterWarrensSearch, killRatHosidius, talkEstateAgent,
		buyCompostPack, pickpocketFruitStalls, bankFruitAndTops, digSaltpetre;
	private NpcStep startQueenOfThieves, talkPoorLookingWoman, talkRobertWithStew;

	// Step 22/23 fields
	private NpcStep buyStavesZaff, talkSirRenitee, killDuckMagic, startDoricsQuest, startBelowIceMountain,
		buyFromJatix, startFishingContest, makeSwordThurgo, eaaCrewmemberPortSarim, eaaTalkBetty, moveHousePollnivneach;
	private DetailedQuestStep bankFaladorGlassKit, reginusToVarlamore, continueEAAUntilPortSarim,
		faladorPortraitCupboard, makeMoltenGlass, completePiratesTreasure, bankForBulkMats,
		killBearSafespot, completeGoblinDiplomacy, completeWitchsHouse, completeDruidicRitual, feroxRestoreAndBank,
		thurgoPohTab, mineBluriteTwo, faladorEastBankGrab, completeKnightsSword, smeltBluriteBar;

	@Override
	public QuestStep loadStep()
	{
		setupRequirements();
		setupSteps();

		var state = new com.questhelper.requirements.runelite.PlayerQuestStateRequirement(
			configManager, getQuest().getPlayerQuests(), 0);

		// Sections 19/20 wired via helpers
		step19 = new Step19Section(this);
		step20 = new Step20Section(this);
		var flow = new com.questhelper.steps.ConditionalStep(this, step19.getDefaultStep());
		step19.wire(flow, state);
		step20.wire(flow, state);

		// Build sections 21, 22, 23
		step21 = new com.questhelper.playerquests.bruhsailer.sections.Step21Section(this);
		step22 = new com.questhelper.playerquests.bruhsailer.sections.Step22Section(this);
		step23 = new com.questhelper.playerquests.bruhsailer.sections.Step23Section(this);
		step24 = new com.questhelper.playerquests.bruhsailer.sections.Step24Section(this);
		step32 = new Step32Section(this);
		step35 = new Step35Section(this);
		step36 = new Step36Section(this);
		step21.wire(flow, state);
		step22.wire(flow, state);
		step23.wire(flow, state);
		step24.wire(flow, state);
		step32.wire(flow, state);
		step35.wire(flow, state);
		step36.wire(flow, state);
		return flow;
	}

	protected void setupRequirements()
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

		coins95672 = new ItemRequirement("Coins", ItemID.COINS, 95672);

		// Step 21
		coins8812 = new ItemRequirement("Coins", ItemID.COINS, 8812);
		stew = new ItemRequirement("Stew", ItemID.STEW);
		airRunes = new ItemRequirement("Air runes", ItemID.AIRRUNE).isNotConsumed();
		mindRunes = new ItemRequirement("Mind runes", ItemID.MINDRUNE).isNotConsumed();
		hammer = new ItemRequirement("Hammer", ItemID.HAMMER).isNotConsumed();
		spade = new ItemRequirement("Spade", ItemID.SPADE).isNotConsumed();
	}

	protected void setupSteps()
	{
		// [19.0] Bank and withdraw everything
		bankStep = new DetailedQuestStep(this, new WorldPoint(3254, 3420, 0),
			"[19.0] Bank: withdraw 1,545 gp, a bronze pickaxe, a house tab, 3 pots of flour, 3 redberries, 6 onions, 2 woad leaves, a pie dish, and a bucket.",
			Arrays.asList(coins1545, bronzePick, pohTab, flour3, redberries3, onions6, woad2, pieDish, bucket), null);
		bankStep.considerBankForItemHighlight = true;

		// [19.1] Break house tab for Rimmington
		breakHouseTab = new DetailedQuestStep(this,
			"[19.1] Break the house teleport tab to Rimmington.", pohTab.highlighted());

		// [19.2] Mine 10 clay + 4 copper at Rimmington mine
		mineClayCopper = new DetailedQuestStep(this, new WorldPoint(2983, 3237, 0),
			"[19.2] Mine 10 clay and 4 copper at the Rimmington mine.", bronzePick);

		// [19.3] Make 3 yellow + 1 blue dye with Aggie in Draynor
		makeDyesAggie = new NpcStep(this, NpcID.AGGIE, new WorldPoint(3086, 3258, 0),
			"[19.3] Run to Draynor. Use onions/woad leaves on Aggie or talk to her to make 3 yellow dyes and 1 blue dye.", onions6, woad2, coins1545);
		makeDyesAggie.addDialogSteps(
			"Can you make dyes for me, please?",
			"Yellow dye.",
			"Blue dye."
		);

		// [19.4] Buy 10 Chronicle cards (Diango - APRILFOOLSHORSESALESMAN)
		buyChronicleCards = new NpcStep(this, NpcID.APRILFOOLSHORSESALESMAN, new WorldPoint(3087, 3251, 0),
			"[19.4] Buy 10 Chronicle cards from Diango in Draynor.", coins1545);

		// [19.5] Ensure items are ready
		ensureFoodItems = new DetailedQuestStep(this,
			"[19.5] Ensure you have a pie dish, a bucket, three pots of flour, and three redberries ready.");

		// Step 20 — Port Sarim to Kourend
		// [20.0] Make pastry doughs and attempt redberry pies
		makePastryAndPies = new DetailedQuestStep(this, new WorldPoint(3013, 3227, 0),
			"[20.0] Walk to Port Sarim. In the northern house with the water icon: make 3 pastry doughs, then one-by-one try to bake cooked redberry pies.",
			flour3, bucket, pieDish, redberries3);

		// [20.1] Buy 16k feathers (and extras if needed for 46 Fletching)
		buyFeathersGerrant = new NpcStep(this, NpcID.GERRANT, new WorldPoint(3013, 3224, 0),
			"[20.1] Buy 16,000 feathers from Gerrant's Fishy Business (Port Sarim). If not 46 Fletching, buy enough extra feathers to reach it.", coins95672);

		// [20.2] Speak with Thurgo (The Knight's Sword)
		talkThurgo = new NpcStep(this, NpcID.THURGO, new WorldPoint(2999, 3146, 0),
			"[20.2] Speak with Thurgo on Mudskipper Point to progress The Knight's Sword.");

		// [20.3] Buy rune packs from Betty
		buyRunesBetty = new NpcStep(this, NpcID.BETTY, new WorldPoint(3014, 3258, 0),
			"[20.3] Buy: 1500 mind (pack), 500 air (pack), 1500 water (pack), 500 earth (pack), 500 fire (pack), 200 body (manual), 100 chaos (manual), 150 death (manual) from Betty's Magic Emporium.", coins95672);

		// [20.4] Veos → Zeah
		veosToZeah = new NpcStep(this, NpcID.VEOS_VISIBLE, new WorldPoint(3054, 3245, 0),
			"[20.4] Talk to Veos in Port Sarim to sail to Great Kourend.", coins95672);
		((NpcStep) veosToZeah).addAlternateNpcs(NpcID.VEOS_VISIBLE_TRAVEL);

		// [20.5] Complete Client of Kourend (turn in to Veos)
		veosCompleteCoK = new NpcStep(this, NpcID.VEOS_VISIBLE, new WorldPoint(1824, 3690, 0),
			"[20.5] Talk to Veos on the Port Piscarilius docks and complete Client of Kourend (destroy lamps; reclaim later for Herblore).");
		((NpcStep) veosCompleteCoK).addAlternateNpcs(NpcID.VEOS_VISIBLE_TRAVEL);

		// [20.6] Veos → Land's End
		veosToLandsEnd = new NpcStep(this, NpcID.VEOS_VISIBLE, new WorldPoint(1824, 3690, 0),
			"[20.6] Talk to Veos again to travel to Land's End.");
		((NpcStep) veosToLandsEnd).addAlternateNpcs(NpcID.VEOS_VISIBLE_TRAVEL);

		// [20.7] Grab hunter supplies
		grabHunterSupplies = new DetailedQuestStep(this, new WorldPoint(1506, 3447, 0),
			"[20.7] At Land's End: grab 1–3 bird snares, five box traps, and a butterfly net (see link in guide).", coins95672);

		// [20.8] Captain Magoro → Port Piscarilius
		captainMagoroToPiscarilius = new DetailedQuestStep(this, new WorldPoint(1504, 3449, 0),
			"[20.8] Speak with Captain Magoro to return to Port Piscarilius.");

		// Reminder overlay
		fletchWhileWalking = new DetailedQuestStep(this,
			"Tip: whenever you are walking long distances, add feathers to arrow shafts while moving.");

		// Step 21 — Piscarilius & Hosidius
		// [21.0] Prep: grab wind strike runes and stew
		piscariliusPrep = new DetailedQuestStep(this, new WorldPoint(1824, 3690, 0),
			"[21.0] In Port Piscarilius, ensure you have wind strike runes (air + mind) and your stew.", airRunes, mindRunes, stew);

		// [21.1] Start The Queen of Thieves
		startQueenOfThieves = new NpcStep(this, NpcID.PISCQUEST_OFFICIAL_VISIBLE, new WorldPoint(1796, 3781, 0),
			"[21.1] Speak to Tomas Lawry in Port Piscarilius to start The Queen of Thieves.");
		startQueenOfThieves.addDialogSteps("I'm looking for a quest.", "What are you investigating?", "Yes.");

		// [21.2] Talk to the poor-looking woman
		talkPoorLookingWoman = new NpcStep(this, NpcID.PISCARILIUS_POOR_CITIZEN_FEMALE_3, new WorldPoint(1803, 3738, 0),
			"[21.2] Speak to the poor-looking woman in Piscarilius.");

		// [21.3] Talk to Robert O'Reilly and give stew
		talkRobertWithStew = new NpcStep(this, NpcID.PISCQUEST_CITIZEN, new WorldPoint(1794, 3757, 0),
			"[21.3] Speak to Robert O'Reilly and give him the stew.", stew);
		talkRobertWithStew.addDialogStep("Okay.");

		// [21.4] Enter Warrens, continue quest to search Hughes's home; browse Warrens General Store
		enterWarrensSearch = new DetailedQuestStep(this, new WorldPoint(1813, 3745, 0),
			"[21.4] Enter the Warrens via the manhole, speak to Devan and the Queen of Thieves until told to search Councillor Hughes' home. Browse the Warrens General Store for the diary.");

		// [21.5] Kill a Giant Rat NE of Hosidius square for its meat and bone
		killRatHosidius = new DetailedQuestStep(this, new WorldPoint(1770, 3620, 0),
			"[21.5] Head south to Hosidius and kill a Giant Rat north-east of Hosidius square for its meat and a giant rat bone.");

		// [21.6] Talk to the Estate Agent (to be able to move POH later)
		talkEstateAgent = new NpcStep(this, NpcID.POH_ESTATE_AGENT, new WorldPoint(1749, 3626, 0),
			"[21.6] Speak to the Estate Agent in Hosidius to unlock moving your POH to Kourend later.");

		// [21.7] Buy a compost pack from Vannah
		buyCompostPack = new DetailedQuestStep(this, new WorldPoint(1759, 3592, 0),
			"[21.7] Buy a compost pack from Vannah's Farm Store in Hosidius.", coins8812);

		// [21.8] Pickpocket fruit stalls to 42+ Thieving, bank berries/fruit/tops
		pickpocketFruitStalls = new DetailedQuestStep(this, new WorldPoint(1783, 3608, 0),
			"[21.8] Pickpocket the two fruit stalls in the house east of Hosidius square until a bit over 42 Thieving (46,512 xp). Eat papayas to restore run energy.");
		bankFruitAndTops = new DetailedQuestStep(this,
			"[21.9] Bank one jangerberry (optionally two for Fairytale I), all strange fruit and golovanova tops (keep at least 2 tops).");

		// [21.10] Dig up saltpetre west of Hosidius
		digSaltpetre = new DetailedQuestStep(this, new WorldPoint(1670, 3505, 0),
			"[21.10] Run west and dig up a saltpetre for the diary.", spade);

		// Step 22 — Varrock → Varlamore → Falador → Multiple quests
		// [22.1] Buy elemental staves from Zaff (Varrock)
		buyStavesZaff = new NpcStep(this, NpcID.ZAFF, new WorldPoint(3202, 3434, 0),
			"[22.1] Use Chronicle to Varrock. Buy one of each elemental staff from Zaff.");
		buyStavesZaff.addDialogStep("Do you have anything to trade?");

		// [22.2] Bank for Falador glassmaking + tools
		bankFaladorGlassKit = new DetailedQuestStep(this,
			"[22.2] Bank: withdraw 7 soda ash, 7 buckets of sand, spade, leather gloves, Wind Strike runes (wind staff + 1200 mind runes), and a Falador teleport.");

		// [22.3] Varlamore: start EAA and continue until Port Sarim step
		reginusToVarlamore = new DetailedQuestStep(this, new WorldPoint(1701, 3143, 0),
			"[22.3] Take the quetzal to Varlamore (Regulus Cento south of Varrock Museum). Start Ethically Acquired Antiquities.");
		continueEAAUntilPortSarim = new DetailedQuestStep(this,
			"[22.3] Continue Ethically Acquired Antiquities until told to visit Port Sarim (then pause EAA).");

		// [22.4] Falador: collect portrait for The Knight's Sword
		faladorPortraitCupboard = new DetailedQuestStep(this, new WorldPoint(2985, 3336, 2),
			"[22.4] Break Falador tab. In Falador Castle (2F), search the cupboard south of the staircase for the portrait.");

		// [22.5] Falador: speak with Sir Renitee (diary)
		talkSirRenitee = new NpcStep(this, NpcID.POH_HERALD_OF_FALADOR, new WorldPoint(2982, 3341, 1),
			"[22.5] Speak with Sir Renitee upstairs in White Knights' Castle for the diary.");

		// [22.6] Make molten glass (Falador furnace or any furnace)
		makeMoltenGlass = new DetailedQuestStep(this,
			"[22.6] Turn the 7 soda ash and 7 sand into molten glass at a furnace.");

		// [22.7] Kill a duck with magic (Falador Park)
		killDuckMagic = new NpcStep(this, NpcID.DUCK_FEMALE, new WorldPoint(2989, 3379, 0),
			"[22.7] Kill a duck in Falador Park using Wind Strike.");
		((NpcStep) killDuckMagic).addAlternateNpcs(NpcID.DUCK);

		// [22.8] Complete Pirate's Treasure
		completePiratesTreasure = new DetailedQuestStep(this,
			"[22.8] Complete Pirate's Treasure using the quest helper.");

		// [22.9] Bank bulk materials
		bankForBulkMats = new DetailedQuestStep(this,
			"[22.9] Bank then withdraw: raw beef, chicken and rat meat; orange + blue dye (or red+yellow to make orange); 2 iron ore, 4 copper ore, 6 clay, 2 cheese, gp stack and 3+ cakes/wines; pickaxe.");

		// [22.10] Doric's Quest
		startDoricsQuest = new NpcStep(this, NpcID.DORIC, new WorldPoint(2951, 3451, 0),
			"[22.10] Run north and speak to Doric to start/complete Doric's Quest using the quest helper.");

		// [22.11] Below Ice Mountain start (Willow)
		startBelowIceMountain = new NpcStep(this, NpcID.BIM_WILLOW, new WorldPoint(3003, 3435, 0),
			"[22.11] Start Below Ice Mountain by speaking to Willow south of Ice Mountain.");

		// [22.12] Safespot bear north of Falador
		killBearSafespot = new DetailedQuestStep(this, new WorldPoint(2960, 3435, 0),
			"[22.12] Safespot a bear on the trees north of Falador for meat, fur, and ribs.");

		// [22.13] Goblin Diplomacy, Witch's House, Druidic Ritual
		completeGoblinDiplomacy = new DetailedQuestStep(this, "[22.13] Complete Goblin Diplomacy using the quest helper.");
		completeWitchsHouse = new DetailedQuestStep(this, "[22.13] Complete Witch's House (safespots exist for all forms). Use the quest helper.");
		completeDruidicRitual = new DetailedQuestStep(this, "[22.13] Complete Druidic Ritual using the quest helper.");

		// [22.14] Jatix (Taverley)
		buyFromJatix = new NpcStep(this, NpcID.JATIX, new WorldPoint(2926, 3439, 0),
			"[22.14] Speak with Jatix in Taverley and buy an eye of newt pack, one empty vial, and a pestle and mortar.");
		((NpcStep) buyFromJatix).addDialogStep("Do you have anything to trade?");

		// [22.15] Start Fishing Contest
		startFishingContest = new NpcStep(this, NpcID.TUNNEL_DWARF1, new WorldPoint(2821, 3486, 0),
			"[22.15] Speak to Vestri north of Catherby to start Fishing Contest, following the quest helper dialogue.");
		((NpcStep) startFishingContest).addDialogSteps(
			"I was wondering what was down those stairs?",
			"Why not?",
			"If you were my friend I wouldn't mind it.",
			"Well, let's be friends!",
			"And how am I meant to do that?",
			"Yes.");

		// [22.16] Ferox restore and bank
		feroxRestoreAndBank = new DetailedQuestStep(this,
			"[22.16] Minigame teleport to Clan Wars (Ferox), restore energy, bank, then withdraw: 2 iron bars, a POH tab, the portrait, 3–5 cakes and a pickaxe.");

		// Step 23 — Thurgo, blurite, EAA, Falador errands
		// [23.1] Break POH tab; back to Thurgo
		thurgoPohTab = new DetailedQuestStep(this, new WorldPoint(3000, 3145, 0),
			"[23.1] Break another POH tab; run to Thurgo south of Port Sarim.");
		// [23.2] Mine two blurite ore (Asgarnian Ice Dungeon)
		mineBluriteTwo = new DetailedQuestStep(this, new WorldPoint(3049, 9566, 0),
			"[23.2] Enter the dungeon south of Port Sarim and mine two blurite ore.");
		// [23.3] Return to Thurgo and make the sword
		makeSwordThurgo = new NpcStep(this, NpcID.THURGO, new WorldPoint(3000, 3145, 0),
			"[23.3] Return to Thurgo with 2 iron bars and make the sword.");
		// [23.4] EAA: Trader Crewmember in Port Sarim
		eaaCrewmemberPortSarim = new NpcStep(this, NpcID.SAILING_TRANSPORT_TRADER_STAN_BASE, new WorldPoint(3036, 3194, 0),
			"[23.4] Speak to Trader Stan (southern deck) in Port Sarim for Ethically Acquired Antiquities.");
		// [23.5] EAA: Talk to Betty
		eaaTalkBetty = new NpcStep(this, NpcID.SARIM_BETTY, new WorldPoint(3011, 3260, 0),
			"[23.5] Talk to Betty at the Rune shop to progress Ethically Acquired Antiquities.");
		// [23.6] Falador east bank; grab items
		faladorEastBankGrab = new DetailedQuestStep(this, new WorldPoint(3013, 3353, 0),
			"[23.6] Run to Falador east bank; withdraw coins (7,500 gp), Ghostspeak amulet, and the Ghost's skull.");
		// [23.7] Move house to Pollnivneach
		moveHousePollnivneach = new NpcStep(this, NpcID.POH_ESTATE_AGENT, new WorldPoint(3240, 3475, 0),
			"[23.7] Speak to an Estate Agent and pay to move your house to Pollnivneach.");
		// [23.8] Complete The Knight's Sword
		completeKnightsSword = new DetailedQuestStep(this, "[23.8] Complete The Knight's Sword using the quest helper.");
		// [23.9] Smelt blurite ore into a bar
		smeltBluriteBar = new DetailedQuestStep(this, "[23.9] Smelt a blurite ore into a bar at a furnace.");
	}

	@Override
	public List<PanelDetails> getPanels()
	{
		List<PanelDetails> p = new ArrayList<>();
		p.add(step19.getPanel());
		p.add(step20.getPanel());
		p.add(step21.getPanel());
		p.add(step22.getPanel());
		p.add(step23.getPanel());
		p.add(step24.getPanel());
		p.add(step32.getPanel());
		p.add(step35.getPanel());
		p.add(step36.getPanel());
		return p;
	}

	@Override
	public List<com.questhelper.rewards.UnlockReward> getUnlockRewards()
	{
		return Collections.emptyList();
	}
}




