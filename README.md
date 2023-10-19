---
# Lucrative Custom Content ~ 💎✨🛠️
##### (`lucrative-mod`)

A remote workspace for the Minecraft mod introducing custom elements to its [namesake modpack](https://www.curseforge.com/minecraft/modpacks/lucrative).

---
# MCreator
#### Custom items and related files

Custom items and their required assets will be contained within MCreator and maintained by the `lucrative.mcreator` file.
This includes functions to obtain modified/intended versions of the items in-game.

Please make a folder for each custom item (and subfolders as necessary) in order to avoid clutter within the MCreator GUI.

---
## Data/Datapack contents
#### Recipes, loot tables, and other data-driven code

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
# Joining the collaborative workspace
#### How to contribute to the repository properly.

## How to create your remote workspace.
1. Download and install MCreator 2023.1
2. Download and install GitHub Desktop
3. Sign into Github, and select the `...@users.noreply.github.com` email. FAILURE TO DO SO WILL RESULT IN BEING UNABLE TO MAKE COMMITS.
4. Inside of GitHub Desktop, select this repository and create a remote clone.
5. Inside of MCreator, click "Open workspace..."
6. Navigate to your clone of the GitHub repository and double-click/open the `lucrative.mcreator` file
7. Wait ~10-15 minutes for MCreator to set up and import the gradle project.

Then you're good to go!

## How to contribute to the repository.

1. ALWAYS FETCH ORIGIN INSIDE OF THE GITHUB DESKTOP APP BEFORE ATTEMPTING TO MAKE CHANGES
   If two people edit the MCreator workspace without pushing to/pulling from master, then it will ALWAYS conflict.
2. Follow the MCreator and Data/Datapack Contents guidelines to make your contributions.
3. Be sure to save all of your work.
4. Close all file windows.
5. Open GitHub Desktop, name your commit in the bottom left (and please provide a summary), then press "commit to **master**".
6. Then, on the right side, select "Push to **origin**".

---
