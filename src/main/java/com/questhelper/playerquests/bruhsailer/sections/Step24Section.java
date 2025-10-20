package com.questhelper.playerquests.bruhsailer.sections;

import com.questhelper.panel.PanelDetails;
import com.questhelper.playerquests.bruhsailer.BruhsailerGuide;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.runelite.PlayerQuestStateRequirement;
import com.questhelper.steps.ConditionalStep;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.NpcStep;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;

import java.util.Arrays;

public class Step24Section
{
	private final BruhsailerGuide quest;

	private ItemRequirement coins12200, shears, oakLogs3, steelNails10, hammer, chisel, buckets5,
		leatherGloves, feathers50, shantayPass, waterskins3, bronzePick, knife, airRunes, mindRunes, chaosRunes;

	private DetailedQuestStep feroxChronicleVarrock, lumbridgeBankPrep, completeRestlessGhost, makeSoftClay,
		ensureBucketsGloves, touristTrapToAna, feudToMayor, finishTouristTrap, finishFeud, blackjackPollnivneach;
	private NpcStep talkCuratorHaig, talkRegulusToVarlamore, talkCuratorHerminius, shearLumbridgeSheep,
		startFeud, shopDommikCrafting, startSleepingGiants, buyShantaySupplies, travelPollnivneachCarpet;

	public Step24Section(BruhsailerGuide quest)
	{
		this.quest = quest;
		setupRequirements();
		setupSteps();
	}

	private void setupRequirements()
	{
		coins12200 = new ItemRequirement("Coins", ItemID.COINS, 12200);
		shears = new ItemRequirement("Shears", ItemID.SHEARS);
		oakLogs3 = new ItemRequirement("Oak logs", ItemID.OAK_LOGS, 3);
		steelNails10 = new ItemRequirement("Steel nails", ItemID.NAILS, 10);
		hammer = new ItemRequirement("Hammer", ItemID.HAMMER).isNotConsumed();
		chisel = new ItemRequirement("Chisel", ItemID.CHISEL).isNotConsumed();
		buckets5 = new ItemRequirement("Buckets", ItemID.BUCKET_EMPTY, 5);
		leatherGloves = new ItemRequirement("Leather gloves", ItemID.LEATHER_GLOVES).isNotConsumed();
		feathers50 = new ItemRequirement("Feathers", ItemID.FEATHER, 50);
		shantayPass = new ItemRequirement("Shantay pass", ItemID.SHANTAY_PASS, 1);
		waterskins3 = new ItemRequirement("Waterskin(4)", ItemID.WATER_SKIN4, 3);
		bronzePick = new ItemRequirement("Bronze pickaxe", ItemID.BRONZE_PICKAXE).isNotConsumed();
		knife = new ItemRequirement("Knife", ItemID.KNIFE).isNotConsumed();
		airRunes = new ItemRequirement("Air runes", ItemID.AIRRUNE, 100).isNotConsumed();
		mindRunes = new ItemRequirement("Mind runes", ItemID.MINDRUNE, 100).isNotConsumed();
		chaosRunes = new ItemRequirement("Chaos runes", ItemID.CHAOSRUNE, 50);
	}

	private void setupSteps()
	{
		feroxChronicleVarrock = new DetailedQuestStep(quest,
			"[24.0] If you need energy, minigame teleport to Clan Wars (Ferox), restore, then Chronicle teleport to Varrock.");

		talkCuratorHaig = new NpcStep(quest, NpcID.CURATOR, new WorldPoint(3257, 3449, 0),
			"[24.1] Speak with Curator Haig Halen in Varrock Museum and push Ethically Acquired Antiquities until he confesses.");

		talkRegulusToVarlamore = new NpcStep(quest, NpcID.VMQ2_QUETZAL_KEEPER_FORTIS, new WorldPoint(1701, 3143, 0),
			"[24.2] Take Regulus Cento's quetzal south of the museum to return to Varlamore.");
		talkRegulusToVarlamore.addAlternateNpcs(NpcID.VMQ2_QUETZAL_KEEPER_2OP, NpcID.VMQ2_QUETZAL_KEEPER_FORTIS);

		talkCuratorHerminius = new NpcStep(quest, NpcID.FORTIS_MUSEUM_CURATOR, new WorldPoint(1712, 3163, 0),
			"[24.3] Speak to Curator Herminius in the Grand Museum of Varlamore to complete Ethically Acquired Antiquities.");

		lumbridgeBankPrep = new DetailedQuestStep(quest, new WorldPoint(3208, 3218, 0),
			"[24.4] Home teleport to Lumbridge and bank. Withdraw 12,200 gp, shears, 3 oak logs, 10 steel nails, hammer, chisel, 5 buckets, leather gloves, 50 feathers, a Shantay pass, 3 waterskins, bronze pickaxe, knife, Wind Strike runes, and chaos runes. Your gp stack should sit near 34,189 gp after the buys.",
			coins12200, shears, oakLogs3, steelNails10, hammer, chisel, buckets5, leatherGloves, feathers50, shantayPass, waterskins3, bronzePick, knife, airRunes, mindRunes, chaosRunes);
		lumbridgeBankPrep.considerBankForItemHighlight = true;

		shearLumbridgeSheep = new NpcStep(quest, NpcID.SHEEPUNSHEERED, new WorldPoint(3209, 3271, 0),
			"[24.5] Shear a sheep north of Lumbridge for its wool.", shears);
		shearLumbridgeSheep.addAlternateNpcs(
			NpcID.SHEEPSHEEREDSHAGGY, NpcID.SHEEPSHEEREDSHAGGY2, NpcID.SHEEPUNSHEERED, NpcID.SHEEPUNSHEEREDG,
			NpcID.SHEEPUNSHEEREDW, NpcID.SHEEPUNSHEERED2, NpcID.SHEEPUNSHEERED2G, NpcID.SHEEPUNSHEERED2W, NpcID.SHEEPUNSHEERED3);

		completeRestlessGhost = new DetailedQuestStep(quest,
			"[24.6] Use the quest helper to finish The Restless Ghost before leaving Lumbridge.");

		startFeud = new NpcStep(quest, NpcID.FEUD_ALI_M, new WorldPoint(3304, 3211, 0),
			"[24.7] Cross the Al-Kharid gate, speak with Ali Morrisane to start The Feud, and buy the desert disguise.", coins12200);

		shopDommikCrafting = new NpcStep(quest, NpcID.DOMMIK, new WorldPoint(3300, 3191, 0),
			"[24.8] Run south to Dommik's Crafting Store. Buy every mould except the bolt mould, grab a second necklace mould, 3 needles, 10 thread, and mithril platelegs.");

		startSleepingGiants = new NpcStep(quest, NpcID.GIANTS_FOUNDRY_KOVAC_QUEST, new WorldPoint(3361, 3147, 0),
			"[24.9] Go east to the Giants' Foundry, start and complete Sleeping Giants with the quest helper.");

		buyShantaySupplies = new NpcStep(quest, NpcID.SHANTAY, new WorldPoint(3303, 3122, 0),
			"[24.10] At Shantay Pass, buy 9 bronze bars, two desert shirts, two desert robes, one pair of desert boots, 5 Shantay passes, 16 bucket packs, 20 buckets of water, and 4 bowls of water. Pick up 10 waterskins and more wines for food if needed.", coins12200);

		makeSoftClay = new DetailedQuestStep(quest, new WorldPoint(3307, 3115, 0),
			"[24.11] Use the bank chest at Shantay Pass to combine water and clay for 4 soft clay while organising supplies.");

		ensureBucketsGloves = new DetailedQuestStep(quest,
			"[24.12] Keep 5 empty buckets ready for Ugthanki dung and equip leather gloves for the upcoming desert quests.", buckets5, leatherGloves);

		touristTrapToAna = new DetailedQuestStep(quest,
			"[24.13] Progress The Tourist Trap up to rescuing Ana (ending with Ana in a barrel). Safespot the Mercenary Captain using this setup: https://www.youtube.com/watch?v=VFxB4zWqrd8");

		feudToMayor = new DetailedQuestStep(quest,
			"[24.14] Continue The Feud until Ali the Mayor sends you back to Ali Morrisane. Gather extra Ugthanki dung plus 3 beers and 3 vodkas along the way. Bring chaos runes to fire bolt spells while safespotting the Mercenary Captain and Tough Guy.",
			chaosRunes);

		finishTouristTrap = new DetailedQuestStep(quest,
			"[24.15] Complete The Tourist Trap now. Place both experience rewards into Agility.");

		finishFeud = new DetailedQuestStep(quest,
			"[24.16] Return to Ali Morrisane in Al-Kharid and finish The Feud.");

		travelPollnivneachCarpet = new NpcStep(quest, NpcID.MAGIC_CARPET_SELLER1, new WorldPoint(3311, 3109, 0),
			"[24.17] Take the magic carpet from Shantay Pass to Pollnivneach.", coins12200);
		travelPollnivneachCarpet.addDialogStep("Pollnivneach");

		blackjackPollnivneach = new DetailedQuestStep(quest, new WorldPoint(3357, 2964, 0),
			"[24.18] Blackjack bearded bandits in Pollnivneach until either your gp stack hits 31,000 gp or you reach 49 Thieving (whichever is later). Fails are common at low level—buy wines nearby and push through.");
	}

	public void wire(ConditionalStep flow, PlayerQuestStateRequirement state)
	{
		flow.addStep(state.getNewState(278), blackjackPollnivneach); blackjackPollnivneach.withId(278);
		flow.addStep(state.getNewState(277), travelPollnivneachCarpet); travelPollnivneachCarpet.withId(277);
		flow.addStep(state.getNewState(276), finishFeud); finishFeud.withId(276);
		flow.addStep(state.getNewState(275), finishTouristTrap); finishTouristTrap.withId(275);
		flow.addStep(state.getNewState(274), feudToMayor); feudToMayor.withId(274);
		flow.addStep(state.getNewState(273), touristTrapToAna); touristTrapToAna.withId(273);
		flow.addStep(state.getNewState(272), ensureBucketsGloves); ensureBucketsGloves.withId(272);
		flow.addStep(state.getNewState(271), makeSoftClay); makeSoftClay.withId(271);
		flow.addStep(state.getNewState(270), buyShantaySupplies); buyShantaySupplies.withId(270);
		flow.addStep(state.getNewState(269), startSleepingGiants); startSleepingGiants.withId(269);
		flow.addStep(state.getNewState(268), shopDommikCrafting); shopDommikCrafting.withId(268);
		flow.addStep(state.getNewState(267), startFeud); startFeud.withId(267);
		flow.addStep(state.getNewState(266), completeRestlessGhost); completeRestlessGhost.withId(266);
		flow.addStep(state.getNewState(265), shearLumbridgeSheep); shearLumbridgeSheep.withId(265);
		flow.addStep(state.getNewState(264), lumbridgeBankPrep); lumbridgeBankPrep.withId(264);
		flow.addStep(state.getNewState(263), talkCuratorHerminius); talkCuratorHerminius.withId(263);
		flow.addStep(state.getNewState(262), talkRegulusToVarlamore); talkRegulusToVarlamore.withId(262);
		flow.addStep(state.getNewState(261), talkCuratorHaig); talkCuratorHaig.withId(261);
		flow.addStep(state.getNewState(260), feroxChronicleVarrock); feroxChronicleVarrock.withId(260);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 24 - Varlamore, Desert Prep & Grinding", Arrays.asList(
			feroxChronicleVarrock, talkCuratorHaig, talkRegulusToVarlamore, talkCuratorHerminius, lumbridgeBankPrep,
			shearLumbridgeSheep, completeRestlessGhost, startFeud, shopDommikCrafting, startSleepingGiants,
			buyShantaySupplies, makeSoftClay, ensureBucketsGloves, touristTrapToAna, feudToMayor,
			finishTouristTrap, finishFeud, travelPollnivneachCarpet, blackjackPollnivneach
		));
	}
}
