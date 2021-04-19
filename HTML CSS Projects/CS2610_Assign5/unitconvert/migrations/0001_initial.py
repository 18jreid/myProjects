# Generated by Django 3.1.7 on 2021-04-19 01:42

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='g',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('lb', models.FloatField(default=0.00220462)),
                ('oz', models.FloatField(default=0.035274)),
                ('t_oz', models.FloatField(default=0.0321507)),
                ('kg', models.FloatField(default=0.001)),
                ('g', models.FloatField(default=1)),
            ],
        ),
        migrations.CreateModel(
            name='kg',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('lb', models.FloatField(default=2.20462)),
                ('oz', models.FloatField(default=35.274)),
                ('t_oz', models.FloatField(default=32.1507)),
                ('kg', models.FloatField(default=1)),
                ('g', models.FloatField(default=1000)),
            ],
        ),
        migrations.CreateModel(
            name='lb',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('lb', models.FloatField(default=1)),
                ('oz', models.FloatField(default=16)),
                ('t_oz', models.FloatField(default=14.5833)),
                ('kg', models.FloatField(default=0.453592)),
                ('g', models.FloatField(default=453.592)),
            ],
        ),
        migrations.CreateModel(
            name='Ounces',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('lb', models.FloatField(default=0.0625)),
                ('oz', models.FloatField(default=1)),
                ('t_oz', models.FloatField(default=0.911458)),
                ('kg', models.FloatField(default=0.0283495)),
                ('g', models.FloatField(default=28.3495)),
            ],
        ),
        migrations.CreateModel(
            name='t_oz',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('lb', models.FloatField(default=0.0685714)),
                ('oz', models.FloatField(default=1.09714)),
                ('t_oz', models.FloatField(default=1)),
                ('kg', models.FloatField(default=0.0311035)),
                ('g', models.FloatField(default=31.1035)),
            ],
        ),
    ]
