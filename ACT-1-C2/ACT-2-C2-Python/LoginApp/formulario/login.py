import tkinter as tk
from tkinter import messagebox, Menu
from clases.usuario import Usuario
from formulario.Panel import FrmPanelControl


class FrmLogin:
    def __init__(self):
        self.window = tk.Tk()
        self.window.title("Login - Tecnar App")
        self.window.geometry("600x400")
        
        tk.Label(self.window, text="Usuario").pack(pady=5)
        self.txt_username = tk.Entry(self.window)
        self.txt_username.pack()

        tk.Label(self.window, text="Clave").pack(pady=5)
        self.txt_clave = tk.Entry(self.window, show="*")
        self.txt_clave.pack()

        tk.Button(self.window, text="Ingresar", command=self.ingresar).pack(pady=20)

        self.window.mainloop()

    def ingresar(self):
        user = self.txt_username.get()
        clave = self.txt_clave.get()

        usuario = Usuario()
        result = usuario.validar_usuario(user, clave)

        if result:
            nombre, apellido, email, username, rol = result
            nombre_completo = f"{nombre} {apellido}"

            messagebox.showinfo("Bienvenido", f"Hola {nombre_completo}")
            self.window.destroy()
            FrmDashboard(nombre_completo, email, rol)
        else:
            messagebox.showerror("Error", "Usuario o clave incorrecta")


class FrmDashboard:
    def __init__(self, nombre_completo, email, rol):
        self.window = tk.Tk()
        self.window.title("Panel de Control - Tecnar App")
        self.window.geometry("600x400")

        menu_principal = Menu(self.window)
        menu_usuarios = Menu(menu_principal, tearoff=0)
        menu_usuarios.add_command(label="Administracion de usuarios")
        menu_principal.add_cascade(label="Usuarios", menu=menu_usuarios)
        self.window.config(menu=menu_principal)

        tk.Label(self.window, text=f"Nombre: {nombre_completo}", font=("Arial", 15)).pack(pady=10)
        tk.Label(self.window, text=f"Email: {email}", font=("Arial", 15)).pack(pady=5)
        tk.Label(self.window, text=f"Rol: {rol}", font=("Arial", 15)).pack(pady=5)

        self.window.mainloop()
