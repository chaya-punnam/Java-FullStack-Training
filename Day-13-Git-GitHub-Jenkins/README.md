# Day-13: Git, GitHub & Jenkins

## Aim

To learn Git version control, GitHub repository management, and Jenkins CI/CD pipeline basics.

---

# Git Basics

## What is Git?

Git is a distributed version control system used to track changes in source code and collaborate with developers.

### Advantages

* Tracks code changes
* Maintains version history
* Supports collaboration
* Easy rollback to previous versions
* Integrates with GitHub, GitLab, and Bitbucket

---

# Git Architecture

```text
Working Directory
        |
        | git add
        v
Staging Area
        |
        | git commit
        v
Local Repository
        |
        | git push
        v
Remote Repository (GitHub)
```

---

# Git Commands

## 1. Check Git Version

```bash
git --version
```

**Purpose:**
Checks whether Git is installed and displays the installed version.

**Example:**

```bash
git version 2.46.0.windows.1
```

---

## 2. Initialize Git Repository

```bash
git init
```

**Purpose:**
Creates a hidden `.git` folder.

**Example Output:**

```text
Initialized empty Git repository in C:/Project/.git/
```

**After Execution:**

```text
Project
│
├── .git
├── src
├── pom.xml
└── README.md
```

---

## 3. Check Repository Status

```bash
git status
```

**Purpose:**

* Checks current branch
* Shows tracked files
* Shows untracked files
* Shows modified files
* Shows staged files

**Example:**

```text
On branch master

Untracked files:
  pom.xml
  src/
```

---

## 4. Add Files to Staging Area

### Add All Files

```bash
git add .
```

**Purpose:**
Moves files from Working Directory to Staging Area.

```text
Working Directory
        ↓
    Staging Area
```

### Add Specific File

```bash
git add HospitalDTO.java
```

---

## 5. Commit Changes

```bash
git commit -m "Initial Commit"
```

**Purpose:**
Saves changes into the local repository.

**Example:**

```text
[master 82cc09e]
Initial Commit
```

---

## 6. View Commit History

```bash
git log
```

**Example:**

```text
commit 82cc09e
Author: Chaya
Date: Wed Jun 24

Initial Commit
```

---

## 7. Connect GitHub Repository

```bash
git remote add origin <repository-url>
```

**Example:**

```bash
git remote add origin https://github.com/chaya-punnam/Doctor-microservice.git
```

---

## 8. Verify Remote Repository

```bash
git remote -v
```

**Output:**

```text
origin  https://github.com/chaya-punnam/Doctor-microservice.git (fetch)
origin  https://github.com/chaya-punnam/Doctor-microservice.git (push)
```

---

## 9. Push Code to GitHub

```bash
git push origin master
```

**Purpose:**
Uploads local repository changes to GitHub.

---

## 10. Pull Latest Changes

```bash
git pull origin master
```

**Purpose:**
Downloads the latest changes from GitHub.

---

## 11. Clone Repository

```bash
git clone <repository-url>
```

**Example:**

```bash
git clone https://github.com/chaya-punnam/Doctor-microservice.git
```

---

## 12. Check Branches

```bash
git branch
```

**Output:**

```text
* master
```

---

## 13. Create Branch

```bash
git branch feature1
```

---

## 14. Switch Branch

```bash
git checkout feature1
```

---

## 15. Create and Switch Branch

```bash
git checkout -b feature1
```

---

# Git Workflow

```text
Create Project
      ↓
git init
      ↓
git status
      ↓
git add .
      ↓
git commit -m "message"
      ↓
git remote add origin URL
      ↓
git push origin master
```

---

# GitHub

## What is GitHub?

GitHub is a cloud-based platform used to store Git repositories online.

### Features

* Repository Hosting
* Source Code Management
* Collaboration
* Pull Requests
* Branch Management
* CI/CD Integration

---

# Steps to Upload Project

### Step 1

Create a repository in GitHub.

### Step 2

Initialize Git.

```bash
git init
```

### Step 3

Add Files.

```bash
git add .
```

### Step 4

Commit Files.

```bash
git commit -m "Initial Commit"
```

### Step 5

Connect GitHub Repository.

```bash
git remote add origin URL
```

### Step 6

Push Code.

```bash
git push origin master
```

---

# Jenkins

## What is Jenkins?

Jenkins is an open-source automation server used for Continuous Integration (CI) and Continuous Deployment (CD).

### Advantages

* Build Automation
* Testing Automation
* Deployment Automation
* GitHub Integration
* Pipeline Support

---

# Jenkins Installation Verification

## Check Jenkins Service

Open browser:

```text
http://localhost:8080
```

If the Jenkins dashboard opens successfully, Jenkins is installed correctly.

---

# Jenkins Pipeline

## Pipeline Structure

```groovy
pipeline {
    agent any

    stages {

        stage('Clone') {
            steps {
                echo 'Cloning Project'
            }
        }

        stage('Build') {
            steps {
                echo 'Building Project'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying Project'
            }
        }
    }
}
```

---

# Jenkins Pipeline Used in Class

## Clone Projects

```groovy
stage('Clone Projects') {
    steps {

        dir('doctor') {
            git url: 'https://github.com/chaya-punnam/Doctor-microservice.git'
        }

        dir('hospital') {
            git url: 'https://github.com/chaya-punnam/Hospital-microservice.git'
        }

        dir('Eureka') {
            git url: 'https://github.com/chaya-punnam/Netflix-Eureka-server.git'
        }

        dir('APIGateWay') {
            git url: 'https://github.com/chaya-punnam/APIGateWay-microservice.git'
        }
    }
}
```

---

## Create JAR Files

```groovy
stage('Create JAR Files') {
    steps {

        dir('doctor') {
            bat 'mvn clean package'
        }

        dir('hospital') {
            bat 'mvn clean package'
        }

        dir('Eureka') {
            bat 'mvn clean package'
        }

        dir('APIGateWay') {
            bat 'mvn clean package'
        }
    }
}
```

---

# CI/CD Flow

```text
Developer
    ↓
Git Commit
    ↓
GitHub Push
    ↓
Jenkins Trigger
    ↓
Clone Project
    ↓
Build Project
    ↓
Create JAR
    ↓
Deploy Application
```

---

# Outcome

Successfully learned:

* Git Installation
* Git Commands
* Git Repository Creation
* GitHub Integration
* Git Push & Pull Operations
* Jenkins Installation
* Jenkins Pipeline Creation
* Jenkins and GitHub Integration
* Maven Build Automation
* JAR File Creation using Jenkins
