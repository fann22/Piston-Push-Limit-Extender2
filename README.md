# Piston Push Limit Extender

A lightweight Forge/Fabric mod that removes the vanilla 12‑block piston push limit and lets you configure it up to 512 blocks via in‑game commands.

## Features

- 🚀 Increase piston push limit anywhere from 0 up to 512.
- ⚙️ Fully configurable at runtime, no restart required.
- 🔄 Respects vanilla piston behavior aside from the new limit.
- 🤝 Compatible with both singleplayer and multiplayer.

## Installation

1. Download the JAR from the [Versions](https://modrinth.com/mod/piston-push-limit-extender/versions) page.  
2. Drop the JAR into your `mods/` folder.  
3. Start your game or server.

## Usage

Use the following in‑game command:
- `/pistonpushlimit <reset|0-512>`

- `reset` → Revert to the vanilla 12‑block limit  
- `0-512` → Set a custom push limit

> ⚠️ Only players with OP or permission level 2+ can run this command.

## Configuration

After first run, a config file is generated at:
- `config/pistonpushlimit.json`
  
> You can also set/edit default value & push limits value manually there.

## Known issue
- Currently is incompatible with Carpet mod

## License

This project is licensed under the [MIT License](https://github.com/fann22/Piston-Push-Limit-Extender/blob/main/LICENSE).