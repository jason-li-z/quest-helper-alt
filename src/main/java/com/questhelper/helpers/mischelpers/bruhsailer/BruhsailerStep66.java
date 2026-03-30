package com.questhelper.helpers.mischelpers.bruhsailer;

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

public class BruhsailerStep66
{
	private final BruhsailerGuide guide;

	// Requirements
	private ItemRequirement waterRunes;
	private ItemRequirement airStaff;
	private ItemRequirement lawRunes;
	private ItemRequirement chaosRunes;
	private ItemRequirement magicWhistles;
	private ItemRequirement magicGoldFeather;
	private ItemRequirement silverBar;
	private ItemRequirement ironBar;

	// Steps
	private DetailedQuestStep teleportToFalador;
	private ObjectStep smeltConductorRod;
	private ObjectStep smeltDemonicSigil;
	private ObjectStep makeHolySymbol;
	private DetailedQuestStep makeHerblore;
	private DetailedQuestStep grabBotanicalPie;
	private NpcStep speakWithAlain;
	private NpcStep speakWithSanfew;
	private DetailedQuestStep goToGoblinVillage;

	public BruhsailerStep66(BruhsailerGuide guide)
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
		waterRunes = new ItemRequirement("Water runes", ItemID.WATERRUNE, -1);
		airStaff = new ItemRequirement("Staff of air", ItemID.STAFF_OF_AIR);
		lawRunes = new ItemRequirement("Law runes", ItemID.LAWRUNE, -1);
		chaosRunes = new ItemRequirement("Chaos runes", ItemID.CHAOSRUNE, -1);
		magicWhistles = new ItemRequirement("Magic whistles", ItemID.MAGIC_WHISTLE, 2);
		magicGoldFeather = new ItemRequirement("Magic gold feather", ItemID.MAGIC_GOLDEN_FEATHER);
		silverBar = new ItemRequirement("Silver bar", ItemID.SILVER_BAR, 2);
		silverBar.setTooltip("One for conductor rod, one for holy symbol");
		ironBar = new ItemRequirement("Iron bar", ItemID.IRON_BAR);
		ironBar.setTooltip("For the demonic sigil");
	}

	private void setupSteps()
	{
		teleportToFalador = new DetailedQuestStep(guide, new WorldPoint(2964, 3378, 0),
			"Teleport to Falador.");

		smeltConductorRod = new ObjectStep(guide, ObjectID.FAI_FALADOR_FURNACE,
			new WorldPoint(2976, 3369, 0),
			"Use the Falador furnace to smelt the conductor rod for Creature of Fenkenstrain. " +
			"You need a silver bar and the conductor mould.", silverBar);

		smeltDemonicSigil = new ObjectStep(guide, ObjectID.FAI_FALADOR_FURNACE,
			new WorldPoint(2976, 3369, 0),
			"Smelt the demonic sigil for Shadow of the Storm at the furnace. " +
			"You need a silver bar and the sigil mould.", silverBar);

		makeHolySymbol = new ObjectStep(guide, ObjectID.FAI_FALADOR_FURNACE,
			new WorldPoint(2976, 3369, 0),
			"Make an unstrung holy symbol using the holy mould and a silver bar, then string it with a ball of wool.");

		makeHerblore = new DetailedQuestStep(guide, new WorldPoint(2964, 3378, 0),
			"If you are not level 27 Herblore yet, make serum 207s, compost potions, and energy " +
			"potions in the bank using your Wintertodt herbs.");

		grabBotanicalPie = new DetailedQuestStep(guide, new WorldPoint(2964, 3378, 0),
			"Grab a botanical pie from the bank and run north to Taverley.");

		speakWithAlain = new NpcStep(guide, NpcID.FARMING_GARDENER_TREE_1,
			new WorldPoint(2933, 3441, 0),
			"Speak with Alain in Taverley if you haven't spoken with 5 farmers yet for Fairytale I. " +
			"Ask about the Group of Advanced Gardeners.");

		speakWithSanfew = new NpcStep(guide, NpcID.SANFEW,
			new WorldPoint(2899, 3429, 1),
			"Boost your Herblore with the botanical pie and speak with Sanfew upstairs in Taverley " +
			"to start Eadgar's Ruse.");

		goToGoblinVillage = new DetailedQuestStep(guide, new WorldPoint(2956, 3505, 0),
			"Head to the Goblin Village and progress Holy Grail and The Lost Tribe. " +
			"For Holy Grail, blow the magic whistle on the sacks. " +
			"Bring your magic gold feather for The Lost Tribe.");
		goToGoblinVillage.addRequirement(magicWhistles);
		goToGoblinVillage.addRequirement(magicGoldFeather);

		teleportToFalador.withId(6601);
		smeltConductorRod.withId(6602);
		smeltDemonicSigil.withId(6603);
		makeHolySymbol.withId(6604);
		makeHerblore.withId(6605);
		grabBotanicalPie.withId(6606);
		speakWithAlain.withId(6607);
		speakWithSanfew.withId(6608);
		goToGoblinVillage.withId(6609);
	}

	public QuestStep getFirstStep()
	{
		return teleportToFalador;
	}

	public List<ItemRequirement> getItemRequirements()
	{
		return Arrays.asList(waterRunes, airStaff, lawRunes, chaosRunes,
			magicWhistles, magicGoldFeather, silverBar, ironBar);
	}

	public List<QuestStep> getSteps()
	{
		return Arrays.asList(teleportToFalador, smeltConductorRod, smeltDemonicSigil, makeHolySymbol, makeHerblore,
			grabBotanicalPie, speakWithAlain, speakWithSanfew, goToGoblinVillage);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 66: Falador Crafting & Quest Progress",
			getSteps(), waterRunes, airStaff, lawRunes, chaosRunes, magicWhistles,
			magicGoldFeather, silverBar, ironBar).withPanelId(66);
	}
}
