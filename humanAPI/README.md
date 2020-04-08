#humanAPI

##How to create a human?

A device can be created using HumanBuilder(). After the properties are set, build() method
will be called. An example can be found here:

    Human human = new HumanBuilder()
                      .setUuid(UUID.randomUUID())
                      .setSkills(createSkills())
                      .setTasks(createTasks())
                      .build(); 
                      
Skills and Tasks can be added using setSkills() and setTasks() methods:

    human.setSkills(skill)
    human.setTasks(task)          
    