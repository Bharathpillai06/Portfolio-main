# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## [Unreleased]

## [2024.12.30]

- Added table-based rubrics to all 6 parts of the project
- Updated gitignore to exclude more files
- Fixed image markdown in the interfaces document

## [2024.08.07]

### Added

- Added `/bin` to `.gitignore`, so binaries are no longer committed
- Added the TODO tree extensions to `extensions.json`
- Added the `todo-tree.general.showActivityBarBadge` setting to `settings.json`
- Added the `todo-tree.tree.showCountsInTree` setting to `settings.json`
- Added the VSCode PDF extension to `extensions.json`
- Added `java.debug.settings.vmArgs` setting to enable assertions (i.e., `-ea`)
- Added information about making branches to all parts of the project
- Added information about how to update the CHANGELOG to every part of the
  project
- Added information about how to make a pull request to every part of the
  project

### Changed

- Updated `settings.json` to format document on save using `editor.formatOnSave`
  setting
- Updated `settings.json` to exclude certain files from markdown to PDF
  generation using `markdown-pdf.convertOnSaveExclude` setting
- Updated `settings.json` to use latest `java.cleanup.actions` setting
- Updated `settings.json` to automatically choose line endings using `files.eol`
  setting
- Updated `settings.json` to organize imports automatically on save using the
  `editor.codeActionsOnSave` and `source.organizeImports` settings
- Changed the component brainstorming assignment to ask a few clarifying
  questions
- Changed the component brainstorming example from `Point3D` to `NaturalNumber`
  to avoid the getter/setter trend
- Updated assignment feedback sections to include a link to a survey that
  I'll actually review
- Updated README to include step about using template repo
- Updated part 3 rubric to include a hierarchy diagram
- Updated part 6 rubric to account for overall polish

### Fixed

- Fixed issue where checkstyle paths would not work on MacOS

### Removed

- Removed `java.saveActions.organizeImports` setting from `settings.json`
- Removed references to `Point3D` completely

## [2024.01.07]

### Added

- Added a list of extensions to capture the ideal student experience
- Added PDFs to the `.gitignore`
- Added the OSU checkstyle config file
- Added the OSU formatter config file
- Added a `settings.json` file to customize the student experience
- Created a README at the root to explain how to use the template repo
- Created initial drafts of the six portfolio assessments
- Added READMEs to key folders like `test` and `lib` to explain their purpose

[2025.12.10]
## Changed

Finished .md files 1–6 with expanded explanations, corrected formatting, clarified examples, and fully updated references for each assignment deliverable.

Fixed

Fixed “The import org.junit cannot be resolved” by reconfiguring project build path, updating JAR linkage, and refreshing Java workspace metadata.

Fixed missing recognition of @Test, assertTrue, and assertEquals by explicitly binding JUnit4 annotations and Hamcrest matchers within Eclipse classpath.

Fixed Java Language Server initialization by clearing cached settings, deleting stale .project metadata, and forcing complete workspace rebuild for dependency indexing.

## Added

Implemented full Playlist component with all methods (add, remove, moveToFront, contains, iterator, newInstance) across Playlist, PlaylistKernel, and PlaylistSecondary.

Implemented Playlist1L including linked-node storage, node traversal logic, edge-case handling for empty lists, and complete kernel-method overrides.

Implemented MusicPlaylistMVP demo showing playlist creation, song insertion, iteration, and printing via toString and user-visible console operations.

Added immutable Song class with validated constructor, public observers (title(), artist(), length()), and precise equality/identity semantics for testing.

Added complete JUnit test suite Playlist1LTest covering boundary cases, iterator behavior, structural invariants, and kernel-method postcondition verification.

Added PlaylistSecondaryTest validating all secondary-method extensions including positionOf, swap, moveToBack, and correct preservation of representation invariants.

Added JUnit4 and Hamcrest JARs to /lib with explicit version pinning, ensuring stable unit testing across development environments.

Added components.jar to provide OSU Components API, enabling contract-based interfaces required for compliant Playlist implementation structure.

Added helper factory methods (makeSongA, makeSongB, etc.) for consistent test setup, reducing duplication and ensuring deterministic test environments.

Added full documentation comments for every class, constructor, observer, and kernel method, explaining preconditions, postconditions, invariants, and expected usage.

Added PlaylistConsoleDemo that demonstrates interactive playlist manipulation, showcasing input/output formatting, playlist operations, and runtime behavior.

## Removed

Removed all TODO markers from docs 1–6 after fully completing explanations, finalizing instructions, and ensuring no unresolved placeholders remained.



[unreleased]: https://github.com/jrg94/portfolio-project/compare/v2024.08.07...HEAD
[2024.08.07]: https://github.com/jrg94/portfolio-project/compare/v2024.01.07...v2024.08.07
[2024.01.07]: https://github.com/jrg94/portfolio-project/releases/tag/v2024.01.07
