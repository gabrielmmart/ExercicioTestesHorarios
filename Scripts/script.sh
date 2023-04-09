cd ExercicioDosHorarios
sudo apt install mailutils
echo "Pipeline executado"
echo ${{ambiente.MY_VARIABLE }}
echo "Mandando e-mail com mail do linux" | mail -s "meu email deu tudo certo" ${{ambiente.MY_VARIABLE}}