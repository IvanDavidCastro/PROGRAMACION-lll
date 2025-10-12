import tkinter as tk
from tkinter import messagebox
from clases.usuario import Usuario

class FrmRegistro:
    def __init__(self):
        self.window = tk.Tk()
        self.window.title("Registro de Usuario - Tecnar App")
        self.window.geometry("400x400")

        tk.Label(self.window, text="Nombre").pack(pady=5)
        self.txt_nombre = tk.Entry(self.window)
        self.txt_nombre.pack()

        tk.Label(self.window, text="Apellido").pack(pady=5)
        self.txt_apellido = tk.Entry(self.window)
        self.txt_apellido.pack()

        tk.Label(self.window, text="Email").pack(pady=5)
        self.txt_email = tk.Entry(self.window)
        self.txt_email.pack()

        tk.Label(self.window, text="Usuario").pack(pady=5)
        self.txt_usuario = tk.Entry(self.window)
        self.txt_usuario.pack()

        tk.Label(self.window, text="Clave").pack(pady=5)
        self.txt_clave = tk.Entry(self.window, show="*")
        self.txt_clave.pack()

        tk.Label(self.window, text="Rol (ej: admin o user)").pack(pady=5)
        self.txt_rol = tk.Entry(self.window)
        self.txt_rol.pack()

        tk.Button(self.window, text="Registrar", command=self.registrar).pack(pady=20)

        self.window.mainloop()

    def registrar(self):
        nombre = self.txt_nombre.get()
        apellido = self.txt_apellido.get()
        email = self.txt_email.get()
        usuario = self.txt_usuario.get()
        clave = self.txt_clave.get()
        rol = self.txt_rol.get()

        if not all([nombre, apellido, email, usuario, clave, rol]):
            messagebox.showerror("Error", "Todos los campos son obligatorios")
            return

        nuevo = Usuario()
        ok = nuevo.registrar_usuario(nombre, apellido, email, usuario, clave, rol)

        if ok:
            messagebox.showinfo("Éxito", "Usuario registrado correctamente")
            self.window.destroy()
        else:
            messagebox.showerror("Error", "No se pudo registrar el usuario")
