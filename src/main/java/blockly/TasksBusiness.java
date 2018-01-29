package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TasksBusiness {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Tasks
	public static Var todo() throws Exception {
		return new Callable<Var>() {

			private Var me = Var.VAR_NULL;
			private Var data = Var.VAR_NULL;

			public Var call() throws Exception {
				return Var.valueOf("ToDo");
			}
		}.call();
	}

	/**
	 */
	// Describe this function...
	public static void assignToMe() throws Exception {
		new Callable<Var>() {

			private Var me = Var.VAR_NULL;
			private Var data = Var.VAR_NULL;

			public Var call() throws Exception {
				me = blockly.UserSkillsBusiness.getEmailfromLoggedUser();
				System.out.println(Var.valueOf(Var.valueOf("I am").toString() + me.toString()).getObjectAsString());
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("Task.active.cronappuser_email"), me);
				data = cronapi.database.Operations.query(Var.valueOf("app.entity.Task"),
						Var.valueOf("select t from Task t where t.id = :id"),
						Var.valueOf("id", cronapi.screen.Operations.getValueOfField(Var.valueOf("Task.active.id"))));
				cronapi.database.Operations.updateField(data, Var.valueOf("cronappuser_email\n"), me);
				cronapi.database.Operations.updateField(data, Var.valueOf("status"), blockly.TasksBusiness.assigned());
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf(Var.valueOf("Tarefa atribuida. Recarregue a página. ID da tarefa:").toString()
								+ cronapi.screen.Operations.getValueOfField(Var.valueOf("Task.active.id")).toString()));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Describe this function...
	public static Var assigned() throws Exception {
		return new Callable<Var>() {

			private Var me = Var.VAR_NULL;
			private Var data = Var.VAR_NULL;

			public Var call() throws Exception {
				return Var.valueOf("Assigned");
			}
		}.call();
	}

}
