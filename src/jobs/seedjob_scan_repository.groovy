multibranchPipelineJob('fc-adm-ci') {
    branchSources {
        git {
            id('fc-adm-ci')
            remote('https://github.com/DFMingYuanZhu/SpringbootTest.git')
            includes('main master develop')
        }
    }

    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }

    configure {
        it / 'trigger' << 'com.cloudbees.hudson.plugins.folder.computed.PeriodicFolderTrigger' {
            spec '* * * * *'
            interval '6000'
        }
    }
}
