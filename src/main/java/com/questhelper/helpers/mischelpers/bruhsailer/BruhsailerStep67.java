package com.questhelper.helpers.mischelpers.bruhsailer;

import com.questhelper.collections.ItemCollections;
import com.questhelper.panel.PanelDetails;
import com.questhelper.questinfo.QuestHelperQuest;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.quest.QuestRequirement;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.NpcStep;
import com.questhelper.steps.QuestStep;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.QuestState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;

public class BruhsailerStep67
{
	private final BruhsailerGuide guide;

	// Requirements
	private ItemRequirement necklaceOfPassage;
	private ItemRequirement dramenStaff;
	private ItemRequirement airRunes;
	private ItemRequirement earthStaff;
	private ItemRequirement lawRunes;
	private ItemRequirement brooch;
	private ItemRequirement scryingOrb;
	private ItemRequirement pickaxe;

	// Steps
	private DetailedQuestStep grabScryingOrbAndPickaxe;
	private DetailedQuestStep teleportToWizardsTower;
	private NpcStep chargeScryingOrb;
	private DetailedQuestStep runToDraynor;
	private DetailedQuestStep continueFairytaleI;
	private DetailedQuestStep teleportToLumbridge;
	private DetailedQuestStep finishLostTribe;
	private NpcStep giveMistagBrooch;
	private NpcStep startDeathToTheDorgeshuun;

	public BruhsailerStep67(BruhsailerGuide guide)
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
		necklaceOfPassage = new ItemRequirement("Necklace of passage", ItemCollections.NECKLACE_OF_PASSAGES);
		dramenStaff = new ItemRequirement("Dramen staff", ItemID.DRAMEN_STAFF);
		airRunes = new ItemRequirement("Air runes", ItemID.AIRRUNE, -1);
		earthStaff = new ItemRequirement("Staff of earth", ItemID.STAFF_OF_EARTH);
		lawRunes = new ItemRequirement("Law runes", ItemID.LAWRUNE, -1);
		brooch = new ItemRequirement("Brooch", ItemID.LOST_TRIBE_BROOCH);
		scryingOrb = new ItemRequirement("Scrying orb", ItemID.SCRYING_ORB_EMPTY);
		pickaxe = new ItemRequirement("Any pickaxe", ItemCollections.PICKAXES);
	}

	private void setupSteps()
	{
		grabScryingOrbAndPickaxe = new DetailedQuestStep(guide,
			"Grab your scrying orb and a pickaxe from the bank.",
			scryingOrb, pickaxe, necklaceOfPassage, dramenStaff, airRunes, earthStaff, lawRunes, brooch);

		teleportToWizardsTower = new DetailedQuestStep(guide, new WorldPoint(3109, 3164, 0),
			"Use your necklace of passage to teleport to the Wizards' Tower.", necklaceOfPassage);

		chargeScryingOrb = new NpcStep(guide, NpcID.HEAD_WIZARD_1OP,
			new WorldPoint(3104, 9571, 0),
			"Have Wizard Sedridor send you to the rune essence mine for the second scrying orb charge, " +
			"then leave the mine.", scryingOrb);

		runToDraynor = new DetailedQuestStep(guide, new WorldPoint(3105, 3249, 0),
			"Run to Draynor Village.");

		continueFairytaleI = new DetailedQuestStep(guide, new WorldPoint(3202, 3169, 0),
			"Continue Fairytale I - enter Zanaris using the dramen staff on the shed in Lumbridge Swamp. " +
			"Talk to the Fairy Godfather, then talk to Fairy Nuff. Progress up to the step where " +
			"you need to visit Zandar Horfyre (do NOT visit Zandar yet).", dramenStaff);

		teleportToLumbridge = new DetailedQuestStep(guide, new WorldPoint(3222, 3218, 0),
			"Teleport to Lumbridge.");

		finishLostTribe = new DetailedQuestStep(guide, new WorldPoint(3209, 9616, 0),
			"Finish The Lost Tribe quest in the Lumbridge basement caves.");
		finishLostTribe.conditionToFadeInSidebar(new QuestRequirement(QuestHelperQuest.THE_LOST_TRIBE, QuestState.FINISHED));

		giveMistagBrooch = new NpcStep(guide, NpcID.LOST_TRIBE_MISTAG_2OPS,
			new WorldPoint(3319, 9615, 0),
			"Give Mistag the brooch to receive a mining helmet.", brooch);

		startDeathToTheDorgeshuun = new NpcStep(guide, NpcID.LOST_TRIBE_MISTAG_2OPS,
			new WorldPoint(3319, 9615, 0),
			"Start Death to the Dorgeshuun by speaking to Mistag. Only do the very first step.");

		grabScryingOrbAndPickaxe.withId(6701);
		teleportToWizardsTower.withId(6702);
		chargeScryingOrb.withId(6703);
		runToDraynor.withId(6704);
		continueFairytaleI.withId(6705);
		teleportToLumbridge.withId(6706);
		finishLostTribe.withId(6707);
		giveMistagBrooch.withId(6708);
		startDeathToTheDorgeshuun.withId(6709);
	}

	public QuestStep getFirstStep()
	{
		return grabScryingOrbAndPickaxe;
	}

	public List<ItemRequirement> getItemRequirements()
	{
		return Arrays.asList(necklaceOfPassage, dramenStaff, airRunes, earthStaff, lawRunes, brooch,
			scryingOrb, pickaxe);
	}

	public List<QuestStep> getSteps()
	{
		return Arrays.asList(grabScryingOrbAndPickaxe, teleportToWizardsTower, chargeScryingOrb, runToDraynor,
			continueFairytaleI, teleportToLumbridge, finishLostTribe, giveMistagBrooch, startDeathToTheDorgeshuun);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 67: Scrying Orb, Fairytale I & The Lost Tribe",
			getSteps(), necklaceOfPassage, dramenStaff, airRunes, earthStaff, lawRunes, brooch,
			scryingOrb, pickaxe).withPanelId(67);
	}
}
