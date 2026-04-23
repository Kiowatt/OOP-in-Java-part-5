package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Consumable;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ConsumableCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ConsumableCreation construct()
    {
        return new ConsumableCreation();
    }

    @Override
    public Item fromDefaults()
    {
        // Maybe call a Default Constructor...
        return new Consumable();
    }

    @Override
    public int requiredNumberOfValues()
    {
        // What is the correct return value?
        return 3;
    }

    @Override
    public Item fromTokens(final String... tokens)
    {
        // Maybe call a Constructor that accepts multiple arguments...
        return new Consumable(
            tokens[0],
            tokens[1],
            Integer.parseInt(tokens[3]));
    }

    @Override
    public Item fromExisting(final Item original)
    {


        Consumable c = (Consumable) original;

        // Maybe call a Constructor that accepts multiple arguments...
        return new Consumable(
            c.getName(),
            c.getEffect(),
            c.getNumberOfUses());
    }
}
