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

public class Step20Section
{
	private final BruhsailerGuide quest;

	private ItemRequirement coins95672;

	private DetailedQuestStep makePastryAndPies, grabHunterSupplies, captainMagoroToPiscarilius, fletchWhileWalking;
	private NpcStep buyFeathersGerrant, talkThurgo, buyRunesBetty, veosToZeah, veosCompleteCoK, veosToLandsEnd;

	public Step20Section(BruhsailerGuide quest)
	{
		this.quest = quest;
		setupRequirements();
		setupSteps();
	}

	private void setupRequirements()
	{
		coins95672 = new ItemRequirement("Coins", ItemID.COINS, 95672);
	}

	private void setupSteps()
	{
		makePastryAndPies = new DetailedQuestStep(quest, new WorldPoint(3013, 3227, 0),
			"[20.0] Walk to Port Sarim. In the northern house with the water icon: make 3 pastry doughs, then one-by-one try to bake cooked redberry pies.");

		buyFeathersGerrant = new NpcStep(quest, NpcID.GERRANT, new WorldPoint(3013, 3224, 0),
			"[20.1] Buy 16,000 feathers from Gerrant's Fishy Business (Port Sarim). If not 46 Fletching, buy enough extra feathers to reach it.", coins95672);

		talkThurgo = new NpcStep(quest, NpcID.THURGO, new WorldPoint(2999, 3146, 0),
			"[20.2] Speak with Thurgo on Mudskipper Point to progress The Knight's Sword.");

		buyRunesBetty = new NpcStep(quest, NpcID.BETTY, new WorldPoint(3014, 3258, 0),
			"[20.3] Buy: 1500 mind (pack), 500 air (pack), 1500 water (pack), 500 earth (pack), 500 fire (pack), 200 body (manual), 100 chaos (manual), 150 death (manual) from Betty's Magic Emporium.", coins95672);

		veosToZeah = new NpcStep(quest, NpcID.VEOS_VISIBLE, new WorldPoint(3054, 3245, 0),
			"[20.4] Talk to Veos in Port Sarim to sail to Great Kourend.", coins95672);
		veosToZeah.addAlternateNpcs(NpcID.VEOS_VISIBLE_TRAVEL);

		veosCompleteCoK = new NpcStep(quest, NpcID.VEOS_VISIBLE, new WorldPoint(1824, 3690, 0),
			"[20.5] Talk to Veos on the Port Piscarilius docks and complete Client of Kourend (destroy lamps; reclaim later for Herblore).");
		veosCompleteCoK.addAlternateNpcs(NpcID.VEOS_VISIBLE_TRAVEL);

		veosToLandsEnd = new NpcStep(quest, NpcID.VEOS_VISIBLE, new WorldPoint(1824, 3690, 0),
			"[20.6] Talk to Veos again to travel to Land's End.");
		veosToLandsEnd.addAlternateNpcs(NpcID.VEOS_VISIBLE_TRAVEL);

		grabHunterSupplies = new DetailedQuestStep(quest, new WorldPoint(1506, 3447, 0),
			"[20.7] At Land's End: grab 1–3 bird snares, five box traps, and a butterfly net (see link in guide).", coins95672);

		captainMagoroToPiscarilius = new DetailedQuestStep(quest, new WorldPoint(1504, 3449, 0),
			"[20.8] Speak with Captain Magoro to return to Port Piscarilius.");

		fletchWhileWalking = new DetailedQuestStep(quest,
			"Tip: whenever you are walking long distances, add feathers to arrow shafts while moving.");
	}

	public void wire(ConditionalStep flow, PlayerQuestStateRequirement state)
	{
		flow.addStep(state.getNewState(208), captainMagoroToPiscarilius); captainMagoroToPiscarilius.withId(208);
		flow.addStep(state.getNewState(207), grabHunterSupplies); grabHunterSupplies.withId(207);
		flow.addStep(state.getNewState(206), veosToLandsEnd); veosToLandsEnd.withId(206);
		flow.addStep(state.getNewState(205), veosCompleteCoK); veosCompleteCoK.withId(205);
		flow.addStep(state.getNewState(204), veosToZeah); veosToZeah.withId(204);
		flow.addStep(state.getNewState(203), buyRunesBetty); buyRunesBetty.withId(203);
		flow.addStep(state.getNewState(202), talkThurgo); talkThurgo.withId(202);
		flow.addStep(state.getNewState(201), buyFeathersGerrant); buyFeathersGerrant.withId(201);
		flow.addStep(state.getNewState(200), makePastryAndPies); makePastryAndPies.withId(200);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 20 — Port Sarim → Kourend", Arrays.asList(
			makePastryAndPies, buyFeathersGerrant, talkThurgo, buyRunesBetty, veosToZeah, veosCompleteCoK, veosToLandsEnd, grabHunterSupplies, captainMagoroToPiscarilius, fletchWhileWalking
		));
	}

	public QuestStep getFirstStep()
	{
		return makePastryAndPies;
	}
}
