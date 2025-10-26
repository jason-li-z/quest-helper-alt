package com.questhelper.playerquests.bruhsailer.sections;

import com.questhelper.questhelpers.PlayerMadeQuestHelper;
import com.questhelper.steps.ConditionalStep;
import com.questhelper.requirements.runelite.PlayerQuestStateRequirement;

public abstract class PlayerMadeQuestSection
{
    protected final PlayerMadeQuestHelper questHelper;

    public PlayerMadeQuestSection(PlayerMadeQuestHelper questHelper)
    {
        this.questHelper = questHelper;
    }

    protected abstract void setupSteps();

    public void wire(ConditionalStep flow, PlayerQuestStateRequirement state)
    {
        // Default wiring implementation, can be overridden by subclasses
    }

    public com.questhelper.panel.PanelDetails getPanel()
    {
        return new com.questhelper.panel.PanelDetails("Step " + getStepNumber(), getDefaultStep());
    }

    protected int getStepNumber()
    {
        // Extracts the step number from the class name, e.g., "Step32Section" -> 32
        try
        {
            return Integer.parseInt(this.getClass().getSimpleName().replaceAll("[^0-9]", ""));
        }
        catch (NumberFormatException e)
        {
            return -1; // Or handle the error as appropriate
        }
    }

    public abstract com.questhelper.steps.DetailedQuestStep getDefaultStep();
}
