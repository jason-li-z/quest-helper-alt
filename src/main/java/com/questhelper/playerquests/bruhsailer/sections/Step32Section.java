package com.questhelper.playerquests.bruhsailer.sections;

import com.questhelper.questhelpers.PlayerMadeQuestHelper;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.runelite.PlayerQuestStateRequirement;
import com.questhelper.steps.ConditionalStep;
import com.questhelper.steps.DetailedQuestStep;
import net.runelite.api.gameval.ItemID;

import java.util.Arrays;

public class Step32Section extends PlayerMadeQuestSection
{
    // Item Requirements
    private ItemRequirement asgarnianAle, wizardsMindBomb, dwarvenStout, roguesOutfit, lockpicks, ropes, trout, salmon, swordfish, gp, blackjack, pohTab;

    // Steps
    private DetailedQuestStep burthorpeTeleport, buyAlesMindBombsStouts, getRoguesOutfit, crackWallSafe,
        buyLockpicksRopes, cookFish, completeFishingContest;

    public Step32Section(PlayerMadeQuestHelper questHelper)
    {
        super(questHelper);
        setupRequirements();
        setupSteps();
    }

    private void setupRequirements()
    {
        gp = new ItemRequirement("Coins", ItemID.COINS, 2546);
        asgarnianAle = new ItemRequirement("Asgarnian ale", ItemID.ASGARNIAN_ALE, 5);
        wizardsMindBomb = new ItemRequirement("Wizard's mind bomb", ItemID.WIZARDS_MIND_BOMB, 39);
        dwarvenStout = new ItemRequirement("Dwarven stout", ItemID.DWARVEN_STOUT, 12);
        roguesOutfit = new ItemRequirement("Rogues outfit", ItemID.ROGUE_MASK).isNotConsumed();
        lockpicks = new ItemRequirement("Lockpick", ItemID.LOCKPICK, 75);
        ropes = new ItemRequirement("Rope", ItemID.ROPE, 25);
        trout = new ItemRequirement("Trout", ItemID.RAW_TROUT, 10);
        salmon = new ItemRequirement("Salmon", ItemID.RAW_SALMON, 15);
        swordfish = new ItemRequirement("Raw swordfish", ItemID.RAW_SWORDFISH, 1);
        blackjack = new ItemRequirement("Willow blackjack", ItemID.WILLOW_BLACKJACK).isNotConsumed();
        pohTab = new ItemRequirement("POH tab", ItemID.TELEPORT_TO_HOUSE, 1);
    }

    @Override
    protected void setupSteps()
    {
        burthorpeTeleport = new DetailedQuestStep(questHelper,
            "[32.0] Minigame teleport to Burthorpe.");

        buyAlesMindBombsStouts = new DetailedQuestStep(questHelper,
            "[32.1] Buy 5 Asgarnian ale, 39 Wizard’s mind bombs and 12 Dwarven stouts.");

        getRoguesOutfit = new DetailedQuestStep(questHelper,
            "[32.2] Collect the Rogues outfit.");

        crackWallSafe = new DetailedQuestStep(questHelper,
            "[32.3] Crack a wall safe in the main area for the diary.");

        buyLockpicksRopes = new DetailedQuestStep(questHelper,
            "[32.4] Buy 75 lockpicks and 25 ropes.");

        cookFish = new DetailedQuestStep(questHelper,
            "[32.5] Cook fish (salmon, trout and all raw fish from Tempoross, but save at least one raw swordfish for making a swordchick at the Tower of Life later for the Ardougne medium diary) between the games to replenish run energy. Make sure you have at least 10 trout for Death Plateau and 15 salmon for In Aid of the Myreque, and got to at least level 43 cooking.");

        completeFishingContest = new DetailedQuestStep(questHelper,
            "[32.6] Grab your GP, blackjack and a POH tab (equip full rogues), run south and complete Fishing Contest.",
            gp, blackjack, pohTab, roguesOutfit);
    }

    @Override
    public void wire(ConditionalStep flow, PlayerQuestStateRequirement state)
    {
        flow.addStep(state.getNewState(326), completeFishingContest);
        flow.addStep(state.getNewState(325), cookFish);
        flow.addStep(state.getNewState(324), buyLockpicksRopes);
        flow.addStep(state.getNewState(323), crackWallSafe);
        flow.addStep(state.getNewState(322), getRoguesOutfit);
        flow.addStep(state.getNewState(321), buyAlesMindBombsStouts);
        flow.addStep(state.getNewState(320), burthorpeTeleport);
    }

    @Override
    public DetailedQuestStep getDefaultStep()
    {
        return burthorpeTeleport;
    }

    @Override
    public com.questhelper.panel.PanelDetails getPanel()
    {
        return new com.questhelper.panel.PanelDetails("Step 32 — Burthorpe & Fishing Contest", Arrays.asList(
            burthorpeTeleport, buyAlesMindBombsStouts, getRoguesOutfit, crackWallSafe, buyLockpicksRopes, cookFish, completeFishingContest
        ), gp, asgarnianAle, wizardsMindBomb, dwarvenStout, lockpicks, ropes, trout, salmon, swordfish, blackjack, pohTab, roguesOutfit);
    }
}