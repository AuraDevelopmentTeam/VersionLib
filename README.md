# Version Lib

[![Current Version](https://badge.fury.io/gh/AuraDevelopmentTeam%2FVersionLib.svg)](https://maven.project-creative.de/service/rest/repository/browse/auradev-releases/dev/aura/lib/version/VersionLib/)
[![Build Status](https://gitlab.project-creative.de/AuraDev/VersionLib/badges/master/build.svg)](https://gitlab.project-creative.de/AuraDev/VersionLib/pipelines)
![Coverage Report](https://gitlab.project-creative.de/AuraDev/VersionLib/badges/master/coverage.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f3362b2ecf874c269017381109a749e4)](https://www.codacy.com/app/AuraDevelopmentTeam/VersionLib?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=AuraDevelopmentTeam/VersionLib&amp;utm_campaign=Badge_Grade)
[![License](https://img.shields.io/github/license/AuraDevelopmentTeam/VersionLib.svg)](https://github.com/AuraDevelopmentTeam/VersionLib/blob/master/LICENSE)

A simple library for comparing versions!

## Table of Contents

- [Downloads](#downloads)
- [Using this library](#using-this-library)
	- [Adding it to your project](#adding-it-to-your-project)
		- [Maven](#maven)
		- [Gradle](#gradle)
	- [Usage](#usage)
- [[Issue Reporting](https://github.com/AuraDevelopmentTeam/VersionLib/issues)](#issue-reportinghttpsgithubcomauradevelopmentteamversionlibissues)
- [[Feature Requests](https://github.com/AuraDevelopmentTeam/VersionLib/issues)](#feature-requestshttpsgithubcomauradevelopmentteamversionlibissues)
- [Developing with our Plugin](#developing-with-our-plugin)
- [Setting up a Workspace/Compiling from Source](#setting-up-a-workspacecompiling-from-source)
- [PGP Signing](#pgp-signing)
- [License](#license)
- [Support](#support)
	- [Getting Support](#getting-support)
	- [Supporting us!](#supporting-us)
- [Random Quote](#random-quote)

## Downloads

You can download all builds from:

- Personal Maven: https://maven.jnc.world/dev/aura/lib/version/VersionLib/

## Using this library

### Adding it to your project

You can easily use this library by including it as a maven dependency, as all releases get uploaded to our maven repository. (Replace `{version}` with the
appropriate version!)

#### Maven

```xml
<repositories>
		<repository>
				<id>AuraDevelopmentTeam</id>
				<url>https://maven.project-creative.de/repository/auradev-releases/</url>
				<!--<url>https://maven.project-creative.de/repository/auradev-snapshots/</url>-->
		</repository>
</repositories>

<dependencies>
		<dependency>
				<groupId>dev.aura.lib.version</groupId>
				<artifactId>VersionLib</artifactId>
				<version>{version}</version>
				<scope>compile</scope>
		</dependency>
</dependencies>
```

#### Gradle

```groovy
repositories {
		maven {
				name "AuraDevelopmentTeam"
				url "https://maven.project-creative.de/repository/auradev-releases/"
				// url "https://maven.project-creative.de/repository/auradev-snaptshots/"
		}
}

dependencies {
		compile "dev.aura.lib.version:VersionLib:{version}"
}
```

### Usage

Create a new `dev.aura.lib.version.Version` object by passing it the version specifier as a string:

```java
new Version("1.2.3-foobar");
```

Then you can use the normal methods like `equals` and `compareTo` to compare versions:

```java
(new Version("1.2.3")).compareTo(new Version("1.2.4")) < 0; // -> true
(new Version("1.2.3")).equals(new Version("1.2.4"));        // -> false
```

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

> Some people, when confronted with a problem, think “I know, I’ll use regular expressions.” Now they have two problems.
>
> — <cite>Jamie Zawinski</cite>
