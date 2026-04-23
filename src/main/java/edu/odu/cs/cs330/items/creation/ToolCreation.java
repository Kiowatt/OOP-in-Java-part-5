package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Tool;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ToolCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "create" since "new" is a reserved keyword in Java.
     */
    public static ToolCreation construct()
    {
        return new ToolCreation();
    }

    @Override
    public Item fromDefaults()
    {
        // Maybe call a Default Constructor...
        return new Tool();
    }

    @Override
    public int requiredNumberOfValues()
    {
        // What is the correct return value?
        return 6;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
        // Maybe call a Constructor that accepts multiple arguments...
        return new Tool(
            tokens[0],
            Integer.parseInt(tokens[2]),
            Integer.parseInt(tokens[3]),
            tokens[1],
            tokens[4],
            Integer.parseInt(tokens[5]));
    }
    @Override
    public Item fromExisting(final Item original)
    {

        Tool t = (Tool) original;

        // Maybe call a Constructor that accepts multiple arguments...
        return new Tool(
            t.getName(),
            t.getDurability(),
            t.getSpeed(),
            t.getMaterial(),
            t.getModifier(),
            t.getModifierLevel()
        );
    }
}
