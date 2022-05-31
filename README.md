# Continuing Education for all things Software

Just keep on learning

## Organizing the repository

### Naming

It's important to keep the naming of files and directories in a consistent manner. The naming schema
applies to all files and directories.

- Files and directories should use [kebab-case][kebab] to denote spaces.
- All files and directories should be lowercase.

#### Directories

The top level directories should be specific to technologies or concepts rather than domain. For example:

```
study-group
  |_ git
  |_ node
```

The above top level directory naming is allowed because `git` and `node` are specific and not a domain of knowledge.

```
study-group
  |_ frontend
  |_ backend
```

The example above `frontend` and `backend` would not be allowed as both are a domain rather then a specific tech.

[kebab]: https://www.theserverside.com/definition/Kebab-case