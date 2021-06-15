interface ITask
{
  id?: string;
  contenido: string;
  importancia: number;
  name_nota: string;
}

interface ITaskOption
{
  type:string;
}
export {ITask,ITaskOption}
