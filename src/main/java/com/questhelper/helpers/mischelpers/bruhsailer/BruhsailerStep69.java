package com.questhelper.helpers.mischelpers.bruhsailer;

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

public class BruhsailerStep69
{
	private final BruhsailerGuide guide;

	private ItemRequirement runeSword;
	private ItemRequirement silverlight;
	private ItemRequirement evilGear;
	private ItemRequirement airRunes;
	private ItemRequirement earthStaff;
	private ItemRequirement lawRunes;
	private ItemRequirement trout;
	private ItemRequirement demonicSigil;
	private ItemRequirement demonicTome;
	private ItemRequirement compostables;
	private ItemRequirement buckets;
	private ItemRequirement volcanicAsh;
	private ItemRequirement compostPotion;

	private DetailedQuestStep finishShadowOfTheStorm;
	private NpcStep startAgrithFight;
	private NpcStep killAgrithNaar;
	private DetailedQuestStep bankAtFerox;
	private DetailedQuestStep makeUltracompost;

	public BruhsailerStep69(BruhsailerGuide guide)
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
		runeSword = new ItemRequirement("Rune sword", ItemID.RUNE_SWORD).isNotConsumed();
		silverlight = new ItemRequirement("Silverlight", ItemID.SILVERLIGHT).isNotConsumed();
		evilGear = new ItemRequirement("Your 'evil gear' from Step 50", -1, -1).isNotConsumed();
		airRunes = new ItemRequirement("Air runes", ItemID.AIRRUNE, -1);
		earthStaff = new ItemRequirement("Staff of earth", ItemID.STAFF_OF_EARTH).isNotConsumed();
		lawRunes = new ItemRequirement("Law runes", ItemID.LAWRUNE, -1);
		trout = new ItemRequirement("Trout", ItemID.TROUT, 10);
		demonicSigil = new ItemRequirement("Demonic sigil", ItemID.AGRITH_SIGIL).isNotConsumed();
		demonicTome = new ItemRequirement("Demonic tome", ItemID.AGRITH_BOOK).isNotConsumed();
		compostables = new ItemRequirement("15 compostable items", -1, 15);
		buckets = new ItemRequirement("Buckets", ItemID.BUCKET_EMPTY, -1);
		volcanicAsh = new ItemRequirement("Volcanic ash", -1, -1);
		compostPotion = new ItemRequirement("Compost potion", -1, -1);
	}

	private void setupSteps()
	{
		finishShadowOfTheStorm = new DetailedQuestStep(guide, new WorldPoint(3270, 3159, 0),
			"Complete The Shadow of the Storm. Use RuneLite's Shadow of the Storm helper for the full quest flow, " +
				"flinch Agrith-Naar with your rune sword if needed, and put the experience reward on Ranged.");
		finishShadowOfTheStorm.addRequirement(runeSword);
		finishShadowOfTheStorm.addRequirement(silverlight);
		finishShadowOfTheStorm.addRequirement(evilGear);
		finishShadowOfTheStorm.addRequirement(airRunes);
		finishShadowOfTheStorm.addRequirement(earthStaff);
		finishShadowOfTheStorm.addRequirement(lawRunes);
		finishShadowOfTheStorm.addRequirement(trout);
		finishShadowOfTheStorm.addRequirement(demonicSigil);
		finishShadowOfTheStorm.addRequirement(demonicTome);
		finishShadowOfTheStorm.conditionToFadeInSidebar(new QuestRequirement(QuestHelperQuest.SHADOW_OF_THE_STORM, QuestState.FINISHED));

		startAgrithFight = new NpcStep(guide, NpcID.AGRITH_MATTHEW, new WorldPoint(2727, 4897, 2),
			"Talk to Matthew in the throne room to begin the Agrith-Naar fight. Oziris' recommended flinch spot is the north-west torch.");

		killAgrithNaar = new NpcStep(guide, NpcID.AGRITH_NAAR,
			"Kill Agrith-Naar. Do not run away when you deal the final hit, and make sure the last blow is with Silverlight.",
			true, silverlight.equipped());

		bankAtFerox = new DetailedQuestStep(guide, new WorldPoint(3151, 3636, 0),
			"After the quest, bank at Ferox Enclave, POH teleport, and head north to your compost setup.");

		makeUltracompost = new DetailedQuestStep(guide, new WorldPoint(3053, 3311, 0),
			"Bring 15 compostable items, a noted bucket stack, volcanic ash, and a compost potion. Unnote the buckets " +
				"through the Tool Leprechaun, collect any optional ultracompost, then make a fresh batch.");
		makeUltracompost.addRequirement(compostables);
		makeUltracompost.addRequirement(buckets);
		makeUltracompost.addRequirement(volcanicAsh);
		makeUltracompost.addRequirement(compostPotion);

		finishShadowOfTheStorm.withId(6901);
		startAgrithFight.withId(6902);
		killAgrithNaar.withId(6903);
		bankAtFerox.withId(6904);
		makeUltracompost.withId(6905);
	}

	public QuestStep getFirstStep()
	{
		return finishShadowOfTheStorm;
	}

	public List<ItemRequirement> getItemRequirements()
	{
		return Arrays.asList(runeSword, silverlight, evilGear, airRunes, earthStaff, lawRunes, trout,
			demonicSigil, demonicTome, compostables, buckets, volcanicAsh, compostPotion);
	}

	public List<QuestStep> getSteps()
	{
		return Arrays.asList(finishShadowOfTheStorm, startAgrithFight, killAgrithNaar, bankAtFerox, makeUltracompost);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 69: Shadow of the Storm & Ultracompost",
			getSteps(),
			runeSword, silverlight, evilGear, airRunes, earthStaff, lawRunes, trout, demonicSigil,
			demonicTome, compostables, buckets, volcanicAsh, compostPotion).withPanelId(69);
	}
}
