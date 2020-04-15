
def tk_get_file_path():
    try:
        import tkinter as tk
        from tkinter import filedialog
    except:
        print("Error: tkinter is not installed/available. Please install and try again")
        sys.exit()

    root = tk.Tk()
    root.withdraw()
    file_path = filedialog.askopenfilename()

    try:
        with open(file_path, 'r') as f:
            pass
    except:
        print("Cancelled")
        sys.exit()

    return file_path


print(tk_get_file_path())
