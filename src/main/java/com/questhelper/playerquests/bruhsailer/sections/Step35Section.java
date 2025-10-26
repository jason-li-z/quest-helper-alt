package com.questhelper.playerquests.bruhsailer.sections;

import com.questhelper.questhelpers.PlayerMadeQuestHelper;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.runelite.PlayerQuestStateRequirement;
import com.questhelper.steps.ConditionalStep;
import com.questhelper.steps.DetailedQuestStep;
import net.runelite.api.gameval.ItemID;

import java.util.Arrays;

public class Step35Section extends PlayerMadeQuestSection
{
    // Item Requirements
    private ItemRequirement flyFishingRod, feathers, gp, natureRunes, waterRunes, earthStaff, food, lawRunes, cosmicRunes, airStaff, fireStaff, wizardMindBombs, mudRune, mistRunes;

    // Steps
    private DetailedQuestStep grabFishingSupplies, catchSalmon, goToMageTrainingArena, collectGraveyardPoints, collectTelekineticPoints, collectAlchemistPoints, collectEnchantmentPoints, buyRunes, unlockBonesToPeaches, castBonesToPeaches;

    public Step35Section(PlayerMadeQuestHelper questHelper)
    {
        super(questHelper);
        setupRequirements();
        setupSteps();
    }

    private void setupRequirements()
    {
        gp = new ItemRequirement("Coins", ItemID.COINS, 10);
        flyFishingRod = new ItemRequirement("Fly fishing rod", ItemID.FLY_FISHING_ROD).isNotConsumed();
        feathers = new ItemRequirement("Feathers", ItemID.FEATHER, 10);
        natureRunes = new ItemRequirement("Nature runes", ItemID.NATURE_RUNE, 1650);
        waterRunes = new ItemRequirement("Water runes", ItemID.WATER_RUNE, 492);
        earthStaff = new ItemRequirement("Staff of earth", ItemID.STAFF_OF_EARTH).isNotConsumed();
        food = new ItemRequirement("Food", ItemID.TUNA, 6);
        lawRunes = new ItemRequirement("Law runes", ItemID.LAW_RUNE, 600);
        cosmicRunes = new ItemRequirement("Cosmic runes", ItemID.COSMIC_RUNE, 5);
        airStaff = new ItemRequirement("Staff of air", ItemID.STAFF_OF_AIR).isNotConsumed();
        fireStaff = new ItemRequirement("Staff of fire", ItemID.STAFF_OF_FIRE).isNotConsumed();
        wizardMindBombs = new ItemRequirement("Wizard's mind bomb", ItemID.WIZARDS_MIND_BOMB, 10);
        mudRune = new ItemRequirement("Mud rune", ItemID.MUD_RUNE, 1);
        mistRunes = new ItemRequirement("Mist runes", ItemID.MIST_RUNE, 10);
    }

    @Override
    protected void setupSteps()
    {
        grabFishingSupplies = new DetailedQuestStep(questHelper,
            "[35.0] Grab a fly fishing rod, 10 feathers and 10gp.");

        catchSalmon = new DetailedQuestStep(questHelper,
            "[35.1] Home teleport to Lumbridge, catch a salmon for the diary.");

        goToMageTrainingArena = new DetailedQuestStep(questHelper,
            "[35.2] Run to the Mage Training Arena. Grab 200 nature runes, 400 water runes, a staff of earth and six food (make sure to have at least 20 empty inventory slots).");

        collectGraveyardPoints = new DetailedQuestStep(questHelper,
            "[35.3] Collect 211 Graveyard points. An easy way is to grab and drop 4 bones once, then after that repeatedly grab a set of 8 bones (20 bananas) and deposit all, eating your food and later your bananas as needed while moving to stay alive.");

        collectTelekineticPoints = new DetailedQuestStep(questHelper,
            "[35.4] Go to the bank, grab 1050 nature runes, 500 law runes, 400 cosmic runes, a staff of air, a staff of earth, a staff of fire and 10 wizard mind bombs. Collect 211 telekinetic points.");

        collectAlchemistPoints = new DetailedQuestStep(questHelper,
            "[35.5] Using low alchemy collect 311 alchemist points (only alch the 30gp items, even if others are free). Optionally use the wizard mind bombs at levels 52-54 to gain access to high alchemy earlier.");

        collectEnchantmentPoints = new DetailedQuestStep(questHelper,
            "[35.6] Collect 2165 enchantment points (lvl-4 enchant in the corner, using a wizard mind bomb as necessary, just drop the shapes after).");

        buyRunes = new DetailedQuestStep(questHelper,
            "[35.7] Buy a mud rune, 10 mist runes.");

        unlockBonesToPeaches = new DetailedQuestStep(questHelper,
            "[35.8] Unlock bones to peaches (this requires boosting to 60 magic with a Wizard’s Mind Bomb).");

        castBonesToPeaches = new DetailedQuestStep(questHelper,
            "[35.9] At some point cast Bones to Peaches in the Al Kharid palace for the diary.");
    }

    @Override
    public void wire(ConditionalStep flow, PlayerQuestStateRequirement state)
    {
        flow.addStep(state.getNewState(359), castBonesToPeaches);
        flow.addStep(state.getNewState(358), unlockBonesToPeaches);
        flow.addStep(state.getNewState(357), buyRunes);
        flow.addStep(state.getNewState(356), collectEnchantmentPoints);
        flow.addStep(state.getNewState(355), collectAlchemistPoints);
        flow.addStep(state.getNewState(354), collectTelekineticPoints);
        flow.addStep(state.getNewState(353), collectGraveyardPoints);
        flow.addStep(state.getNewState(352), goToMageTrainingArena);
        flow.addStep(state.getNewState(351), catchSalmon);
        flow.addStep(state.getNewState(350), grabFishingSupplies);
    }

    @Override
    public DetailedQuestStep getDefaultStep()
    {
        return grabFishingSupplies;
    }

    @Override
    public com.questhelper.panel.PanelDetails getPanel()
    {
        return new com.questhelper.panel.PanelDetails("Step 35 — Mage Training Arena", Arrays.asList(
            grabFishingSupplies, catchSalmon, goToMageTrainingArena, collectGraveyardPoints, collectTelekineticPoints, collectAlchemistPoints, collectEnchantmentPoints, buyRunes, unlockBonesToPeaches, castBonesToPeaches
        ), gp, flyFishingRod, feathers, natureRunes, waterRunes, earthStaff, food, lawRunes, cosmicRunes, airStaff, fireStaff, wizardMindBombs, mudRune, mistRunes);
    }
}