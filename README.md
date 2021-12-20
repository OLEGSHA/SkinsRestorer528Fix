# SkinsRestorer582Fix

This is a simplistic workaround for SkinsRestorerX issue [#582](https://github.com/SkinsRestorer/SkinsRestorerX/issues/582): if a server has SkinsRestorerX installed and a server resourcepack exists, the resourcepack prompt does not appear at all or disappears quickly. This plugin solves this issue by sending a command, `/sr applyskin <player>`, when the player is done dealing with the resourcepack.

## Usage

1. Set server resourcepack as normal;
2. Change `DisableOnJoinSkins` to `true` in `plugins/SkinsRestorer/config.yml`;
3. Download and install this plugin.

## Method of operation

When the client acknowledges the rejection, successful installation or failure to install the resourcepack requested by the server, the plugin issues the following command:
```
sr applyskin <player>
```
with `<player>` replaced with the player's login. The command is issued by a custom `CommandSender` that has all permissions and that is an operator. Command output is suppressed.

## Building

```bash
git clone https://github.com/OLEGSHA/SkinsRestorer528Fix.git
cd SkinsRestorer528Fix
./gradlew build
```