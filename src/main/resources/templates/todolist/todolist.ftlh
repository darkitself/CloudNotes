<#import "../parts/common.ftlh" as c>

<@c.page>
    <a href="/api/todolist/all">To do lists</a>
    <#if response.role != 'VIEWER'>
        <form method="post" action="/api/todolist/task/create/${response.toDoList.id}">
            <label>
                Task: <input type="text" name="task" value=""><input type="submit" value="Create task">
            </label>
        </form>
    </#if>
    <form method="post" action="/api/todolist/update/${response.toDoList.id}">
        <div>List name:</div>
        <div>
            <label>
                <input
                        <#if response.role == 'VIEWER'>readonly</#if>
                        type="text" name="name" size="40"
                        value="${response.toDoList.name}">
            </label>
        </div>
        <div>Tasks:</div>
        <#list response.toDoList.tasks as task>
            <div>
                <input type="hidden" name="tasks[${task?counter}].id" value="${task.id}">
                <label>
                    <input <#if response.role == 'VIEWER'>readonly</#if> size="40" type="text"
                           name="tasks[${task?counter}].task"
                           value="${task.task}"/>
                </label>
                <label>
                    <select <#if response.role == 'VIEWER'>readonly</#if> name="tasks[${task?counter}].state">
                        <#list response.states as state>
                            <option value="${state}"
                                    <#if task.state == state>selected</#if>> ${state.description}</option>
                        </#list>
                    </select>
                </label>
            </div>
            <br>
        </#list>
        <#if response.role != 'VIEWER'>
            <p><input type="submit" value="Update"></p>
        </#if>
    </form>
</@c.page>