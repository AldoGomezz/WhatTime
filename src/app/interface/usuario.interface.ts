interface UsuarioInterface
{
  id?: string,
  nombre: string,
  correo: string

}
interface CreateUsuario
{
   name:string,
   correo: string,
   password: string

}
export {UsuarioInterface,CreateUsuario}
