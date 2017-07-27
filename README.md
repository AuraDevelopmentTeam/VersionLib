# Version Lib

[![Current Version](https://badge.fury.io/gh/AuraDevelopmentTeam%2FVersionLib.svg)](https://maven.jnc.world/dev/aura/lib/version/VersionLib/)
[![Build Status](https://gitlab.brainstonemod.com/AuraDev/VersionLib/badges/master/build.svg)](https://gitlab.brainstonemod.com/AuraDev/VersionLib/pipelines)
[![Coverage Report](https://gitlab.brainstonemod.com/AuraDev/VersionLib/badges/master/coverage.svg)](https://gitlab.brainstonemod.com/AuraDev/VersionLib/pipelines)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f3362b2ecf874c269017381109a749e4)](https://www.codacy.com/app/AuraDevelopmentTeam/VersionLib?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=AuraDevelopmentTeam/VersionLib&amp;utm_campaign=Badge_Grade)
[![Issue Stats](https://img.shields.io/issuestats/i/github/AuraDevelopmentTeam/VersionLib.svg)](https://github.com/AuraDevelopmentTeam/VersionLib/issues)
[![License](https://img.shields.io/github/license/AuraDevelopmentTeam/VersionLib.svg)](https://github.com/AuraDevelopmentTeam/VersionLib/blob/master/LICENSE)

A simple library for comparing versions!

## Table of Contents

- [Downloads](#downloads)
- [Developing with the API](#developing-with-the-api)
	- [Maven](#maven)
	- [Gradle](#gradle)
- [Issue Reporting](#issue-reporting)
- [Feature Requests](#feature-requests)
- [Developing with our Plugin](#developing-with-our-plugin)
- [Setting up a Workspace/Compiling from Source](#setting-up-a-workspacecompiling-from-source)
- [Development builds](#development-builds)
- [PGP Signing](#pgp-signing)
- [License](#license)
- [Support](#support)
	- [Getting Support](#getting-support)
	- [Supporting us!](#supporting-us)

## Downloads

You can download all builds from:

- Personal Maven: https://maven.jnc.world/dev/aura/lib/version/VersionLib/

## Developing with the API

You can easily use this library by including it as a maven dependency, as all releases get uploaded to our maven repository. (Replace `{version}` with the
appropriate version!)
 
### Maven

    <repositories>
        <repository>
            <id>AuraDevelopmentTeam/id>
            <url>https://maven.jnc.world</url>
        </repository>
    </repositories>
    
    <dependencies>
        <dependency>
            <groupId>dev.aura.lib.version</groupId>
            <artifactId>VersionLib</artifactId>
            <version>{version}</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

### Gradle

    repositories {
        maven {
            name "AuraDevelopmentTeam"
            url "https://maven.jnc.world"
        }
    }

    dependencies {
        provided "dev.aura.lib.version:VersionLib:{version}"
    }

## [Issue Reporting](https://github.com/AuraDevelopmentTeam/VersionLib/issues)

If you found a bug or even are experiencing a crash please report it so we can fix it. Please check at first if a bug report for the issue already
[exits](https://github.com/AuraDevelopmentTeam/VersionLib/issues). If not just create a
[new issue](https://github.com/AuraDevelopmentTeam/VersionLib/issues/new) and fill out the form.

Please include the following:

* Version Lib version
* Java version
* For crashes:
  * Steps to reproduce
  * Logs if available

*(When creating a new issue please follow the template)*

## [Feature Requests](https://github.com/AuraDevelopmentTeam/VersionLib/issues)

If you want a new feature added, go ahead an open a [new issue](https://github.com/AuraDevelopmentTeam/VersionLib/issues/new), remove the existing form and
describe your feature the best you can. The more details you provide the easier it will be implementing it.  
You can also talk to us on [Discord](https://dicord.me/bungeechat).

## Developing with our Plugin

So you want to add support or even develop an add-on for our plugin then you can easily add our API to your development environment, read the
[API documentation](https://github.com/AuraDevelopmentTeam/BungeeChat2/blob/master/BungeeChatApi/README.md).

## Setting up a Workspace/Compiling from Source

* Clone:  
  Clone the repository like this: `git clone --recursive https://github.com/AuraDevelopmentTeam/VersionLib.git`
* IDE-Setup:  
  Run [gradle] in the repository root: `./gradlew installLombok <eclipse|idea>`
* Build:  
  Run [gradle] in the repository root: `./gradlew build`. The build will be in `build/libs`
* If obscure Gradle issues are found try running `./gradlew cleanCache clean`

## PGP Signing

All files will be signed with PGP.  
The public key to verify it can be found in `misc/publicKey.asc`. The signatures of the files will also be found in the maven.

## License

Version Lib is licensed under the [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.html)

## Support

### Getting Support

If you need help with anything, want to discuss issues or suggestions, or just want to say hi, you can visit our
[Discord Server (https://discord.me/bungeechat)](https://discord.me/bungeechat).

### Supporting us!

Thanks for scrolling down so far!  
We are developing this plugin (and others!) as well as providing constant support for all our plugins free of charge so that as many people as possible can use
it! Since it is still a lot of work we would really appreciate it if you could support us on [Patreon](https://www.patreon.com/AuraDev)!

<p align="center"><a href="https://www.patreon.com/bePatron?u=6416598"><img alt="Become a Patreon" src="https://c5.patreon.com/external/logo/become_a_patron_button.png"></a></p>

## Random Quote

> In software, we rarely have meaningful requirements. Even if we do, the only measure of success that matters is whether our solution solves the customer’s
> shifting idea of what their problem is.
>
> — <cite>Jeff Atwood</cite>
