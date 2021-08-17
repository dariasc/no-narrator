# !narrator

A small mod that disables the **ctrl** + **b** narrator keybind (I hit it way to often...).

It achieves this through a mixin in the `net.minecraft.client.Keyboard` class, stopping any call to `GameOptions.cycle()` inside the `Keyboard.onKey()` method.
