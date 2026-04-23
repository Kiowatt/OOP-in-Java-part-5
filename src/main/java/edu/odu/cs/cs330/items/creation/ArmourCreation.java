package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Armour;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ArmourCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ArmourCreation construct()
    {
        return new ArmourCreation();
    }

    @Override
    public Item fromDefaults()
    {
        // Maybe call a Default Constructor...
        return new Armour();
    }

    @Override
    public int requiredNumberOfValues()
    {
        // What is the correct return value?
        return 8;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
        // Maybe call a Constructor that accepts multiple arguments...
        return new Armour(
            tokens[1],
            Integer.parseInt(tokens[3]),
            Integer.parseInt(tokens[4]),
            tokens[2],
            tokens[5],
            Integer.parseInt(tokens[6]),
            tokens[7]);
    }


    @Override
    public Item fromExisting(final Item original)
    {


        Armour a = (Armour) original;

        // Maybe call a Constructor that accepts multiple arguments...
        return new Armour(
            a.getName(),
            a.getDurability(),
            a.getDefense(),
            a.getMaterial(),
            a.getModifier(),
            a.getModifierLevel(),
            a.getElement());
    }
}
