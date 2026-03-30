package com.questhelper.helpers.mischelpers.bruhsailer;

import com.questhelper.collections.ItemCollections;
import com.questhelper.panel.PanelDetails;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.QuestStep;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;

public class BruhsailerStep75
{
	private final BruhsailerGuide guide;

	// Requirements
	private ItemRequirement axe;
	private ItemRequirement knife;
	private ItemRequirement coins;

	// Steps
	private DetailedQuestStep bankForTeaks;
	private DetailedQuestStep travelToSoulWars;
	private DetailedQuestStep doTwoTickTeaks;
	private DetailedQuestStep optionalForestryWorld;
	private DetailedQuestStep optionalSulliuscep;
	private DetailedQuestStep optionalLogBasket;
	private DetailedQuestStep optionalPushTo75;
	private DetailedQuestStep returnToNormalSpellbook;

	public BruhsailerStep75(BruhsailerGuide guide)
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
		axe = new ItemRequirement("Any axe", ItemCollections.AXES);
		knife = new ItemRequirement("Knife", ItemID.KNIFE);
		knife.setTooltip("For 2-tick teak manipulation (use knife on teak logs)");
		coins = new ItemRequirement("Coins", ItemID.COINS, 1000);
		coins.setTooltip("For log basket purchase if needed");
	}

	private void setupSteps()
	{
		bankForTeaks = new DetailedQuestStep(guide,
			"Bank and grab your axe and knife for 2-tick teaks. If you plan to use the " +
			"Arceuus spellbook for fairy ring access, switch now before heading out.",
			axe, knife);

		travelToSoulWars = new DetailedQuestStep(guide, new WorldPoint(2209, 2860, 0),
			"Travel to the Soul Wars island for 2-tick teaks. You can get there via the " +
			"minigame teleport (Soul Wars) or by using a fairy ring to reach nearby areas. " +
			"The teak trees are located on the island.");

		doTwoTickTeaks = new DetailedQuestStep(guide, new WorldPoint(2209, 2860, 0),
			"Cut teak trees using the 2-tick method: use your knife on the teak logs " +
			"in your inventory while standing next to the teak tree to reset the chop timer. " +
			"This significantly increases Woodcutting XP rates. Drop logs as your inventory fills. " +
			"Continue until you reach your target Woodcutting level.",
			axe, knife);

		optionalForestryWorld = new DetailedQuestStep(guide,
			"(Optional) Consider switching to a Forestry world for bonus Woodcutting XP " +
			"from Forestry events. Forestry events spawn periodically and give additional " +
			"XP and rewards. Note: world-hopping in some cave areas may place you at the " +
			"cave exit, so hop before entering any caves.");

		optionalSulliuscep = new DetailedQuestStep(guide, new WorldPoint(3627, 3693, 0),
			"(Optional) Cut Sulliuscep mushroom trees on Fossil Island for Woodcutting XP " +
			"and fossils. Travel to Fossil Island via the barge at the Digsite. " +
			"The Sulliuscep cap route is in the Tar Swamp - bring antipoison as the " +
			"swamp can poison you. Each cap gives good Woodcutting XP and a chance at fossils.",
			axe);

		optionalLogBasket = new DetailedQuestStep(guide,
			"(Optional) Purchase or prepare a log basket from the Forestry shop if available. " +
			"The log basket lets you store logs while training, reducing time spent dropping.",
			coins);

		optionalPushTo75 = new DetailedQuestStep(guide,
			"(Optional) Continue cutting teaks or Sulliusceps to push to 75 Woodcutting. " +
			"This unlocks magic trees and provides a significant boost to future content. " +
			"Only do this if it fits your overall plan - you can always return later.",
			axe, knife);

		returnToNormalSpellbook = new DetailedQuestStep(guide,
			"If you switched to the Arceuus spellbook earlier, return to the normal " +
			"spellbook by praying at the altar in Lumbridge or any other standard altar. " +
			"Make sure you are on the correct spellbook before continuing to the next step.");

		bankForTeaks.withId(7501);
		travelToSoulWars.withId(7502);
		doTwoTickTeaks.withId(7503);
		optionalForestryWorld.withId(7504);
		optionalSulliuscep.withId(7505);
		optionalLogBasket.withId(7506);
		optionalPushTo75.withId(7507);
		returnToNormalSpellbook.withId(7508);
	}

	public QuestStep getFirstStep()
	{
		return bankForTeaks;
	}

	public List<ItemRequirement> getItemRequirements()
	{
		return Arrays.asList(axe, knife, coins);
	}

	public List<QuestStep> getSteps()
	{
		return Arrays.asList(bankForTeaks, travelToSoulWars, doTwoTickTeaks,
			optionalForestryWorld, optionalSulliuscep, optionalLogBasket,
			optionalPushTo75, returnToNormalSpellbook);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 75: Teaks & Woodcutting",
			getSteps(),
			axe, knife, coins).withPanelId(75);
	}
}
