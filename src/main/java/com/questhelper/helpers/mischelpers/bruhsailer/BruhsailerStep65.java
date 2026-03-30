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

public class BruhsailerStep65
{
	private final BruhsailerGuide guide;

	// Requirements
	private ItemRequirement coins;
	private ItemRequirement bread;
	private ItemRequirement trout;
	private ItemRequirement ironBar;
	private ItemRequirement asgarnianAle;
	private ItemRequirement premadeBlurbSpecial;
	private ItemRequirement climbingBoots;

	// Steps
	private DetailedQuestStep bankAtFerox;
	private DetailedQuestStep completeDeathPlateau;
	private DetailedQuestStep completeTrollStronghold;
	private NpcStep buyClimbingBoots;
	private DetailedQuestStep keepTrollBone;

	public BruhsailerStep65(BruhsailerGuide guide)
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
		coins = new ItemRequirement("Coins", ItemID.COINS, 120);
		bread = new ItemRequirement("Bread", ItemID.BREAD, 10);
		trout = new ItemRequirement("Trout", ItemID.TROUT, 10);
		ironBar = new ItemRequirement("Iron bar", ItemID.IRON_BAR);
		asgarnianAle = new ItemRequirement("Asgarnian ale", ItemID.ASGARNIAN_ALE);
		premadeBlurbSpecial = new ItemRequirement("Premade blurb' sp.", ItemID.PREMADE_BLURBERRY_SPECIAL);
		climbingBoots = new ItemRequirement("Climbing boots", ItemID.DEATH_CLIMBINGBOOTS);
	}

	private void setupSteps()
	{
		bankAtFerox = new DetailedQuestStep(guide, new WorldPoint(3151, 3636, 0),
			"Bank at Ferox Enclave and grab items for Death Plateau and Troll Stronghold. " +
			"You will also need wind strike runes or bolts for combat.");
		bankAtFerox.addRequirement(coins);
		bankAtFerox.addRequirement(bread);
		bankAtFerox.addRequirement(trout);
		bankAtFerox.addRequirement(ironBar);
		bankAtFerox.addRequirement(asgarnianAle);
		bankAtFerox.addRequirement(premadeBlurbSpecial);

		completeDeathPlateau = new DetailedQuestStep(guide, new WorldPoint(2896, 3529, 0),
			"Complete the Death Plateau quest. Use minigame teleports or your games necklace for travel. " +
			"Select 'Death Plateau' in Quest Helper for detailed steps.");
		completeDeathPlateau.conditionToFadeInSidebar(new QuestRequirement(QuestHelperQuest.DEATH_PLATEAU, QuestState.FINISHED));

		completeTrollStronghold = new DetailedQuestStep(guide, new WorldPoint(2896, 3529, 0),
			"Complete the Troll Stronghold quest. Make sure to free Eadgar and unlock the secret " +
			"south entrance to the stronghold. If you get the troll bone for Rag and Bone Man II " +
			"at any point during the troll quests, keep it.");
		completeTrollStronghold.conditionToFadeInSidebar(new QuestRequirement(QuestHelperQuest.TROLL_STRONGHOLD, QuestState.FINISHED));

		buyClimbingBoots = new NpcStep(guide, NpcID.DEATH_SHERPA, new WorldPoint(2820, 3555, 0),
			"Buy 5 extra pairs of climbing boots from Tenzing.", coins.quantity(60));

		keepTrollBone = new DetailedQuestStep(guide,
			"Keep the troll bone if you obtained one during the troll quests. It is needed for Rag and Bone Man II.");

		bankAtFerox.withId(6501);
		completeDeathPlateau.withId(6502);
		completeTrollStronghold.withId(6503);
		buyClimbingBoots.withId(6504);
		keepTrollBone.withId(6505);
	}

	public QuestStep getFirstStep()
	{
		return bankAtFerox;
	}

	public List<ItemRequirement> getItemRequirements()
	{
		return Arrays.asList(coins, bread, trout, ironBar, asgarnianAle, premadeBlurbSpecial);
	}

	public List<QuestStep> getSteps()
	{
		return Arrays.asList(bankAtFerox, completeDeathPlateau, completeTrollStronghold, buyClimbingBoots, keepTrollBone);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 65: Death Plateau & Troll Stronghold",
			getSteps(), coins, bread, trout, ironBar, asgarnianAle, premadeBlurbSpecial).withPanelId(65);
	}
}
