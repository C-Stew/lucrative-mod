---
# Lucrative Custom Content
##### (`lucrative-mod`)

A remote workspace for the Minecraft mod introducing custom elements to its [namesake modpack](https://www.curseforge.com/minecraft/modpacks/lucrative).

---
## MCreator
### Custom items and related files

Custom items and their required assets will be contained within MCreator and maintained by the `lucrative.mcreator` file.
This includes functions to obtain modified/intended versions of the items in-game.

Please make a folder for each custom item (and subfolders as necessary) in order to avoid clutter within the MCreator GUI.

---
## Data/Datapack contents
### Recipes, loot tables, and other data-driven code

These are mechanics that do not require actual Forge mod features.
This includes recipes, loot tables, data tags, and other modifications which can be done with a datapack.

Please add these files directly to **src > main > resources** and then **assets** or **data** as necessary.
Datapack content should always be placed inside of a `lucrative` namespace unless they modify:
1. Existing Loot Tables
2. Existing Recipes
3. Existing Data Tags
4. Other Existing Data

In which case, please place these data files inside the appropriate namespace.

In the case of custom data in the `lucrative` namespace, do not be afraid to add as many subfolders as you see fit to enable comprehensive file navigation.

---
