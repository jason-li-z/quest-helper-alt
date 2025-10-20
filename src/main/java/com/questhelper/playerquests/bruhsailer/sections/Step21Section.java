package com.questhelper.playerquests.bruhsailer.sections;

import com.questhelper.panel.PanelDetails;
import com.questhelper.playerquests.bruhsailer.BruhsailerGuide;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.runelite.PlayerQuestStateRequirement;
import com.questhelper.steps.ConditionalStep;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.NpcStep;
import com.questhelper.steps.ObjectStep;
import net.runelite.api.gameval.ObjectID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;

import java.util.Arrays;

public class Step21Section
{
	private final BruhsailerGuide quest;

	private ItemRequirement coins8812, stew, airRunes, mindRunes, hammer, spade;

	private DetailedQuestStep piscariliusPrep, enterWarrensSearch, killRatHosidius, talkEstateAgent,
		buyCompostPack, pickpocketFruitStalls, bankFruitAndTops, digSaltpetre;
	private NpcStep startQueenOfThieves, talkPoorLookingWoman, talkRobertWithStew;

	public Step21Section(BruhsailerGuide quest)
	{
		this.quest = quest;
		setupRequirements();
		setupSteps();
	}

	private void setupRequirements()
	{
		coins8812 = new ItemRequirement("Coins", ItemID.COINS, 8812);
		stew = new ItemRequirement("Stew", ItemID.STEW);
		airRunes = new ItemRequirement("Air runes", ItemID.AIRRUNE).isNotConsumed();
		mindRunes = new ItemRequirement("Mind runes", ItemID.MINDRUNE).isNotConsumed();
		hammer = new ItemRequirement("Hammer", ItemID.HAMMER).isNotConsumed();
		spade = new ItemRequirement("Spade", ItemID.SPADE).isNotConsumed();
	}

	private void setupSteps()
	{
		piscariliusPrep = new DetailedQuestStep(quest, new WorldPoint(1824, 3690, 0),
			"[21.0] In Port Piscarilius, ensure you have wind strike runes (air + mind) and your stew.", airRunes, mindRunes, stew);

		startQueenOfThieves = new NpcStep(quest, NpcID.PISCQUEST_OFFICIAL_VISIBLE, new WorldPoint(1796, 3781, 0),
			"[21.1] Speak to Tomas Lawry in Port Piscarilius to start The Queen of Thieves.");
		startQueenOfThieves.addDialogSteps("I'm looking for a quest.", "What are you investigating?", "Yes.");

		talkPoorLookingWoman = new NpcStep(quest, NpcID.PISCARILIUS_POOR_CITIZEN_FEMALE_3, new WorldPoint(1803, 3738, 0),
			"[21.2] Speak to the poor-looking woman in Piscarilius.");

		talkRobertWithStew = new NpcStep(quest, NpcID.PISCQUEST_CITIZEN, new WorldPoint(1794, 3757, 0),
			"[21.3] Speak to Robert O'Reilly and give him the stew.", stew);
		talkRobertWithStew.addDialogStep("Okay.");

        enterWarrensSearch = new ObjectStep(quest, ObjectID.PISCQUEST_MANHOLE_OPEN, new WorldPoint(1813, 3745, 0),
                "[21.4] Enter the Warrens via the manhole, speak to Devan and the Queen of Thieves until told to search Councillor Hughes' home. Browse the Warrens General Store for the diary.");
        ((ObjectStep) enterWarrensSearch).addAlternateObjects(ObjectID.PISCQUEST_MANHOLE_CLOSED);

		killRatHosidius = new DetailedQuestStep(quest, new WorldPoint(1770, 3620, 0),
			"[21.5] Head south to Hosidius and kill a Giant Rat north-east of Hosidius square for its meat and a giant rat bone.");

		talkEstateAgent = new NpcStep(quest, NpcID.POH_ESTATE_AGENT, new WorldPoint(1749, 3626, 0),
			"[21.6] Speak to the Estate Agent in Hosidius to unlock moving your POH to Kourend later.");

		buyCompostPack = new DetailedQuestStep(quest, new WorldPoint(1759, 3592, 0),
			"[21.7] Buy a compost pack from Vannah in Hosidius general store.", coins8812);

		pickpocketFruitStalls = new DetailedQuestStep(quest, new WorldPoint(1783, 3608, 0),
			"[21.8] Pickpocket from the fruit stalls in the house on the east of Hosidius square to a bit over 42 thieving");

		bankFruitAndTops = new DetailedQuestStep(quest,
			"[21.9] Bank one jangerberry (optionally: bank two as it’s a possible Fairytale pt. 1 item), all the strange fruit and the golovanova tops (you will need at least 2 tops).");

		digSaltpetre = new DetailedQuestStep(quest, new WorldPoint(1670, 3505, 0),
			"[21.10]  Run west and dig up a saltpetre for the diary", spade);
	}

	public void wire(ConditionalStep flow, PlayerQuestStateRequirement state)
	{
		flow.addStep(state.getNewState(219), digSaltpetre); digSaltpetre.withId(219);
		flow.addStep(state.getNewState(218), bankFruitAndTops); bankFruitAndTops.withId(218);
		flow.addStep(state.getNewState(217), pickpocketFruitStalls); pickpocketFruitStalls.withId(217);
		flow.addStep(state.getNewState(216), buyCompostPack); buyCompostPack.withId(216);
		flow.addStep(state.getNewState(215), talkEstateAgent); talkEstateAgent.withId(215);
		flow.addStep(state.getNewState(214), killRatHosidius); killRatHosidius.withId(214);
		flow.addStep(state.getNewState(213), enterWarrensSearch); enterWarrensSearch.withId(213);
		flow.addStep(state.getNewState(212), talkRobertWithStew); talkRobertWithStew.withId(212);
		flow.addStep(state.getNewState(211), talkPoorLookingWoman); talkPoorLookingWoman.withId(211);
		flow.addStep(state.getNewState(210), startQueenOfThieves); startQueenOfThieves.withId(210);
		flow.addStep(state.getNewState(209), piscariliusPrep); piscariliusPrep.withId(209);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 21 — Piscarilius & Hosidius", Arrays.asList(
			piscariliusPrep, startQueenOfThieves, talkPoorLookingWoman, talkRobertWithStew, enterWarrensSearch, killRatHosidius, talkEstateAgent, buyCompostPack, pickpocketFruitStalls, bankFruitAndTops, digSaltpetre
		));
	}
}
